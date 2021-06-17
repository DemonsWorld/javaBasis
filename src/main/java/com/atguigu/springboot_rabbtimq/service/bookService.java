package com.atguigu.springboot_rabbtimq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Kakrolot
 * @date 2020/4/26 20:29
 */
@Service
public class bookService {

    @RabbitListener(queues = "test_b_route_queue")
    public void receive(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
