package com.example.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {


    public static final String EXCHANGE_NAME = "testexchange";

    @Bean("queue1")
    Queue createQueue() {
        return new Queue("firstQueue", false);
    }

    @Bean("queue2")
    public Queue secondQueue() {
        return new Queue("secondQueue", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(@Qualifier("queue1") Queue q, TopicExchange exchange) {
        return BindingBuilder.bind(q).to(exchange).with("test.#");
    }

    @Bean
    Binding binding1(@Qualifier("queue2") Queue q, TopicExchange exchange) {
        return BindingBuilder.bind(q).to(exchange).with("test.#");
    } //br nechta queue yaratsak bitta TopicExchange ga xar bir queueni binding qilib chiqamiz
    //TopicExchange larni boshqacha varianti xam bor.

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(simpleMessageConverter()); //shu yerga commentdagi methodni yozsak ham bo`lar edi json kutganimizda
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleMessageConverter simpleMessageConverter() {
        return new SimpleMessageConverter();
    }

}
