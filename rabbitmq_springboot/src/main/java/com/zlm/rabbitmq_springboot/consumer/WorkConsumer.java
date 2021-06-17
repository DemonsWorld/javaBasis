package com.zlm.rabbitmq_springboot.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Kakrolot
 * @date 2021/6/15 20:37
 */
@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiver1(String message){
        System.out.println("work consumer1 = " +message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiver2(String message){
        System.out.println("work consumer2  = " +message);
    }

}
