origin_amqp模型
    day1:消息队列的简单连接，以及点对点模型
    day2：多个消息消费者以循环的方式获取消息队列中的消息，平均分配，自动确认，一次性将消息分配到各个消费者手上
         消息确认机制确保消息不丢失，以手动确认的方式，在执行完一个消息操作之后，继续分配任务。
    day3：发布订阅模式（Publish/subscribe）fanout
    day4：Routing之订阅模型-direct
    day5：routing之订阅模型-topic 支持通配符
           * can substitute for exactly one word
           # can substitute for zero or more words
       
springboot整合rabbitmq

rabbitMQ的应用场景
    1 异步处理
        场景：用户注册后，需要发送邮件或者发送短信，以上任务完成后，返回给客户端，并行方式
    2 应用解耦
        场景：
    3 流量晓峰
        场景：
        
rabbitMQ的集群
    
        

        


      

      