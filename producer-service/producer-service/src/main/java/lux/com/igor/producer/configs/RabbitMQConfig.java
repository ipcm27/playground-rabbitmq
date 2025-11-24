package lux.com.igor.producer.configs;


import lombok.extern.log4j.Log4j2;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Log4j2
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME_MARKETPLACE = "marketplace.direct";
    public static final String QUEUE_PRODUCT_LOG = "my.queue";
    public static final String ROUTING_KEY_PRODUCT_LOG = "my.rk";

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
