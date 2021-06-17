package day4;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author Kakrolot
 * @date 2021/6/8 22:40
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        //创建一个临时队列
        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName,"logs_direct","info");
        channel.queueBind(queueName,"logs_direct","error");
        channel.queueBind(queueName,"logs_direct","warn");



        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("消费者2 "+new String(body));
            }
        });


    }
}