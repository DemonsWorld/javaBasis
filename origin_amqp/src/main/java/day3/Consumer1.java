package day3;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author Kakrolot
 * @date 2021/6/8 20:19
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        //通道绑定交换机
        channel.exchangeDeclare("logs","fanout");

        //临时队列
        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName,"logs","");

        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("消费者1 "+new String(body));
            }
        });



    }
}
