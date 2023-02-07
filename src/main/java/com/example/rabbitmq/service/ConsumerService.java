package com.example.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Author: Alisher Odilov
 * Date: 04.02.2023
 */
@Service
public class ConsumerService {

    @RabbitListener(queues = {"firstQueue"})
    public void receiveMessage(@Payload String fileBody) {
        System.out.println("Consume :  " + fileBody);
    }

    @RabbitListener(queues = {"secondQueue"})
    public void receiveMessage1(@Payload String fileBody) {
        System.out.println(fileBody);
    }
}

//shu Serviceni o`zi yetadi queue ni listen qilib turish uchun