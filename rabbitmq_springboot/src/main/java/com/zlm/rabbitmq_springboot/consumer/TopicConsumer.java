package com.zlm.rabbitmq_springboot.consumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Kakrolot
 * @date 2021/6/15 22:25
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topics",type = "topic"),
                    key = {"use.#","product.*"}

            )
    })
    void receiver1(String message){
        System.out.println("topic consumer 1 message"+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topics",type = "topic"),
                    key = {"use.#","product.*"}

            )
    })
    void receiver2(String message){
        System.out.println("topic consumer 2 message"+message);
    }
}
