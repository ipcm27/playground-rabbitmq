package lux.com.igor.producer.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lux.com.igor.producer.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static lux.com.igor.producer.configs.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static lux.com.igor.producer.configs.RabbitMQConfig.RK_PRODUCT_LOG;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message){
        log.info("Received message{}", message);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }
}
