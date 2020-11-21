package org.cly.rabbitmq.controller;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
@RabbitListener(queuesToDeclare =@Queue(value = "renke.fanout.queue"))
public class RouterConsumer2 {
    @RabbitHandler
    public void getMessage(String message){
        System.out.println("RouterConsume2开始消费："+message);
    }
}
