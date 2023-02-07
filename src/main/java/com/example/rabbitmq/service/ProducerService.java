package com.example.rabbitmq.service;

/**
 * Author: Alisher Odilov
 * Date: 04.02.2023
 */


import com.example.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void send(String values) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, values);
    }
}