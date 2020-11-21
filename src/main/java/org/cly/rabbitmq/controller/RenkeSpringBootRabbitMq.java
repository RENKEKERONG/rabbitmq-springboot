package org.cly.rabbitmq.controller;

import org.cly.rabbitmq.config.RabbitmqConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbit-mq/test")
public class RenkeSpringBootRabbitMq {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping(value = "routerHello")
    public void HelloWorld(){
        //第一个参数是key即路由，第二个参数是发送的内容，这种属于点对点消费，不是广播模式
        //因此当有多个消费者时会有顺序的消费该消息，但每次只能有一个消费者消费
        rabbitTemplate.convertAndSend("renke.hello","这是renke.hello");
    }

    /**
     * 使用交换机类型为fanout，因为fanout会忽略掉routerKey，因此routerkey填写也是无效的
     */
    @GetMapping(value = "pubsub")
    public void PubSub(){
        rabbitTemplate.convertAndSend("renke.fanout","","这是pubsub模型");

    }



}
