package com.atguigu.springboot_rabbtimq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootRabbtimqApplicationTests {

    public static final String Exchange_NAME = "test_exchange_route";

    public static final String QUEUE_NAME = "test_b_route_queue";

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void declare(){
        amqpAdmin.declareExchange(new DirectExchange("admin.exchange"));
        amqpAdmin.declareQueue(new Queue("admin.queue",false));
        amqpAdmin.declareBinding(new Binding("admin.queue", Binding.DestinationType.QUEUE,"admin.exchange","admin.hah",null));
    }


    @Test
    void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","this is the first message");
        rabbitTemplate.convertAndSend(Exchange_NAME,"info",map);
    }

    @Test
    public void receive(){
        Object queue_name = rabbitTemplate.receiveAndConvert(QUEUE_NAME);
        System.out.println(queue_name);
    }

}
