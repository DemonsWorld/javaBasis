package com.zlm.rabbitmq_springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

@SpringBootTest
@RunWith(SpringRunner.class)
class RabbitmqSpringbootApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //simple queue
    @Test
    void simpleProvider() {
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    //work queue
    @Test
    void workProvider(){
        rabbitTemplate.convertAndSend("work","hello work");
    }

    //work queue 轮询处理，公平消费
    @Test
    void workProvider2(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello work"+i);
        }
    }

    //广播
    @Test
    void fanoutProvider(){
        rabbitTemplate.convertAndSend("logs","","fanout模型发送的消息");
    }

    //路由模式
    @Test
    void routeProvider(){
        rabbitTemplate.convertAndSend("directs","info","发送info类型的信息");
    }

    //动态路由 订阅模式
    @Test
    void topicProvider(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save路由发送的消息");
    }


}
