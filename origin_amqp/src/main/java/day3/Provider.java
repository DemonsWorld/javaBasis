package day3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author Kakrolot
 * @date 2021/6/8 19:49
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs","fanout");

        channel.basicPublish("logs","",null,"fanout message".getBytes());

        RabbitMQUtils.closeConenction(channel,connection);
    }
}
