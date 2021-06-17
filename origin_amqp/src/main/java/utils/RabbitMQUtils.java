package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Kakrolot
 * @date 2021/6/6 15:08
 */
public class RabbitMQUtils {

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("ems");
    }

    public static Connection getConnection(){
        try{
            return connectionFactory.newConnection();
        }catch (Exception e){

        }finally {

        }
        return null;
    }

    public static void closeConenction(Channel channel,Connection connection){
        try {
            if(channel!=null) channel.close();
            if(connection!=null) connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
