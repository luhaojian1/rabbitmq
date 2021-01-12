package com.mq.rabbitmq_provider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqProviderController {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqProviderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/direct")
    public void sentDirectMsg(){
        try {
            rabbitTemplate.convertAndSend("DirectRouting", "Hello World!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @PostMapping("/topic")
    public void sentTopicMsg(){

    }

}
