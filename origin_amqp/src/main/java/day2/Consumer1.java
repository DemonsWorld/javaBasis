package day2;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @author Kakrolot
 * @date 2021/6/7 20:54
 */
public class Consumer1 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        final Channel channel = connection.createChannel();

        //通道每次只能消费一个消息
        channel.basicQos(1);

        channel.queueDeclare("work",true,false,false,null);



        //false:autoAck 取消自动确认
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("consumer 1 "+ new String(body));
                //手动确认 参数1：手动确认的消息表示 参数2：false 每次确认一个

                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });


    }


}
