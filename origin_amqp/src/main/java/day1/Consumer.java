package day1;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Kakrolot
 * @date 2021/6/5 14:32
 */
public class Consumer {

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
        //参数3：exclusive 是否独占队列
        //参数4：autoDelete 是否在消费完成后自动删除队列
        //参数5：额外附加参数
        channel.queueDeclare("hello",false,false,false,null);

        //参数1：消费队列的名称
        //参数2: 开启消息的自动确认机制
        //参数3：消费消息时的毁掉接口
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body));
            }
        });



    }
}
