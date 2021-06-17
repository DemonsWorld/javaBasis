package day2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author Kakrolot
 * @date 2021/6/7 20:54
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("work",true,false,false,null);

        for(int i = 10;i<100;i++){
            channel.basicPublish("","work",null,(i+" hello work queue").getBytes());
        }

        RabbitMQUtils.closeConenction(channel,connection);



    }
}
