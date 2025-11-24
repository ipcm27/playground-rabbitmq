package lux.com.igor.producer.configs;


import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import lombok.extern.log4j.Log4j2;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static constants.RabbitMQConstants.*;


@Configuration
@Log4j2
public class RabbitMQConfig {

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }


    // Criei a fila
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_PRODUCT_LOG, false, false, false);
    }

    // Criei a Exchange
    @Bean
    public DirectExchange directExchange() {
        DirectExchange exchange = new DirectExchange(EXCHANGE_NAME_MARKETPLACE, false, false);
        log.info("Created new exchange {}", exchange.getName());
        return exchange;
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(ROUTING_KEY_PRODUCT_LOG);
    }


}
