package org.cly.rabbitmq.hello;

import org.cly.rabbitmq.config.RabbitmqConfiguration;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value =RabbitmqConfiguration.QUEUE_USER))
public class HelloConsumer {

    @RabbitHandler
    public void getMessage(String message){
        System.out.println("default hello consumer receive-->"+message);
    }
}
