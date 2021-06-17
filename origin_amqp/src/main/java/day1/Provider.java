package day1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import utils.RabbitMQUtils;

import javax.activation.MailcapCommandMap;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Kakrolot
 * @date 2021/6/3 22:38
 */
public class Provider {

    public static void main(String[] args) throws IOException, TimeoutException {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("127.0.0.1");
//        connectionFactory.setPort(5672);
//
//        connectionFactory.setVirtualHost("/ems");
//        connectionFactory.setUsername("ems");
//        connectionFactory.setPassword("ems");

        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        //获取连接中通道
        Channel channel = connection.createChannel();

        //通道绑定对应消息队列
        //参数1：队列名称
        //参数2：用来定义队列特性是都要持久化
        //参数3：exclusive 是否独占队列,判断该队列只能被某一个连接使用
        //参数4：autoDelete 是否在消费完成后自动删除队列
        //参数5：额外附加参数
        channel.queueDeclare("helloMQ1",false,false,true,null);

        //参数1：交换机名称
        //参数2：队列名
        //参数3：消息属性：MessageProperties.PERSISTENT_TEXT_PLAIN，设置消息持久化
        //参数4：消息byte数组
        channel.basicPublish("","hello", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabbitMQ".getBytes());

//        channel.close();
//
//        connection.close();
        RabbitMQUtils.closeConenction(channel,connection);



    }
}
