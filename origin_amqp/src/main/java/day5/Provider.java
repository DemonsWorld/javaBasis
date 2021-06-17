package day5;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author Kakrolot
 * @date 2021/6/9 22:34
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        String exchangeName = "topics";

        channel.exchangeDeclare(exchangeName,"topic");

        String routingKey = "user.save.delete";

        channel.basicPublish(exchangeName,routingKey,null,("topic动态路由模型:"+routingKey).getBytes());

        RabbitMQUtils.closeConenction(channel,connection);

    }
}
