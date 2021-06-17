package day4;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author Kakrolot
 * @date 2021/6/8 22:30
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        String exchangeName = "logs_direct";
        //声明交换机 参数1：交换机名称 参数2：路由模式
        channel.exchangeDeclare(exchangeName,"direct");

        String routeKey = "info";

        channel.basicPublish(exchangeName,routeKey,null,"direct模型发布的基于routeKey".getBytes());

        RabbitMQUtils.closeConenction(channel,connection);


    }
}
