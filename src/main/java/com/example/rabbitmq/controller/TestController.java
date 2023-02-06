package com.example.rabbitmq.controller;

/**
 * Author: Alisher Odilov
 * Date: 04.02.2023
 */

import com.example.rabbitmq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rabbit")
@RestController
public class TestController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/test/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        producerService.send(message);
        return "send";
    }
}
