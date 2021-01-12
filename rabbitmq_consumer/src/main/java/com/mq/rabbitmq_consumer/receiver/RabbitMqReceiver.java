package com.mq.rabbitmq_consumer.receiver;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RabbitMqReceiver {

    @RabbitListener(bindings = {@QueueBinding(value = @Queue("TestDirectQueue"),key = "DirectRouting",exchange = @Exchange("DirectExchange"))
    })
    @RabbitHandler
    public void process(String message) {
        System.out.println("DirectReceiver消费者收到消息  : " + message);
    }

}

