package com.example.rabbitmq.service;

/**
 * Author: Alisher Odilov
 * Date: 04.02.2023
 */


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {


    private final RabbitTemplate rabbitTemplate;

    private final Queue queue;
    private final Queue queue1;


    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate, @Qualifier("queue1") Queue queue, @Qualifier("queue2") Queue queue1) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.queue1 = queue1;
    }

    public void send(String values) {
        rabbitTemplate.convertAndSend(this.queue.getName(), values);
//        rabbitTemplate.convertAndSend(this.queue1.getName(),values); agar shuni yozsak pastdagi methodni keragi ham yo`q
    }

    public void send2(String values) {
        rabbitTemplate.convertAndSend(this.queue1.getName(), values);
    }
}