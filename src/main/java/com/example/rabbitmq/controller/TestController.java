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

    @GetMapping("/test2/{message}")
    public String sendMessage2(@PathVariable("message") String message) {
        producerService.send2(message);
        return "send";
    }
    //brauserdan test qilishda get yozdim chunki brauserda faqat get method ishlaydi postni httpda tekshirishimiz kerak
}
