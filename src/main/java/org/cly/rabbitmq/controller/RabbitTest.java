package org.cly.rabbitmq.controller;

import org.cly.rabbitmq.fanout.FanoutProducer;
import org.cly.rabbitmq.hello.DefaultProducer;
import org.cly.rabbitmq.topic.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbit-mq/test")
public class RabbitTest {

    @Autowired
    private FanoutProducer fanoutProducer;

    @Autowired
    private DefaultProducer defaultProducer;

    @Autowired
    private TopicProducer topicProducer;

    @GetMapping("/default")
    public void sendDefaultMessage(){
        defaultProducer.sendDefaultMessage();
    }

    @GetMapping("/fanout")
    public void sendFanoutMessage(){
        fanoutProducer.sendMessage();
    }

    @GetMapping("/topic")
    public void sendTopicMessage(){
        topicProducer.sendMessage();
    }


}
