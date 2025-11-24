package lux.com.igor.producer.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static constants.RabbitMQConstants.EXCHANGE_NAME_MARKETPLACE;
import static constants.RabbitMQConstants.ROUTING_KEY_PRODUCT_LOG;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message){
        log.info("Producing message {}", message);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG, message);
    }
}
