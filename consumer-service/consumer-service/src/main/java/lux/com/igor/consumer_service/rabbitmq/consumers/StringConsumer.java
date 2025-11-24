package lux.com.igor.consumer_service.rabbitmq.consumers;

import dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StringConsumer {

    @RabbitListener(queues = { "my.queue" })
    public void consumer(String message) {
        log.info("Consumer received a message {}", message);
    }

}
