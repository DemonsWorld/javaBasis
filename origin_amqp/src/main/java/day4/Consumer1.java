package day4;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author Kakrolot
 * @date 2021/6/8 22:40
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        String exchangeName = "logs_direct";
        //声明交换机 参数1：交换机名称 参数2：路由模式
        channel.exchangeDeclare(exchangeName,"direct");
        //创建一个临时队列
        String queueName = channel.queueDeclare().getQueue();



        //基于routeKey绑定队列到交换机上
        channel.queueBind(queueName,exchangeName,"error");

        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("消费者1 "+new String(body));
            }
        });


    }
}
