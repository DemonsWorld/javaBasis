package com.zlm.rabbitmq_springboot.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Kakrolot
 * @date 2021/6/15 20:20
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class SimpleConsumer {

    @RabbitHandler
    public void receiver(String  message){
        System.out.println("message "+ message);
    }



}
