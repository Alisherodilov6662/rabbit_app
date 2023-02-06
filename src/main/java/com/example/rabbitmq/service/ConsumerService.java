package com.example.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Author: Alisher Odilov
 * Date: 04.02.2023
 */
@Service
public class ConsumerService {

    @RabbitListener(queues = {"forTest"})
    public void receiveMessage(String fileBody) {
        System.out.println("Consume :  " + fileBody);
    }

    @RabbitListener(queues = {"testqueueno2"})
    public void receiveMessage1(String fileBody) {
        System.out.println(fileBody);
    }
}