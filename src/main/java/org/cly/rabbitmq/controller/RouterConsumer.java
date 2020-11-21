package org.cly.rabbitmq.controller;

import org.cly.rabbitmq.config.RabbitmqConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
//Queue该注解是重点可以点进去查看源码：第一个参数：routingKey（路由）
//第二个参数无消费时是否持久化磁盘，也就是当消息还在队列时，如果重启RabbitMqdurable
// 为true是会序列化到磁盘，重启加载到RabbitMq，为false则重启消失
//第三个参数，消费后是否自动删除autoDelete为true
@RabbitListener(queues = RabbitmqConfiguration.myFanoutQueue)
public class RouterConsumer {
    @RabbitHandler
    public void getMessage(String message) {
        System.out.println("RouterConsume开始消费：" + message);

    }
}
