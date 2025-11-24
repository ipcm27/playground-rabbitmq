package lux.com.igor.consumer_service.rabbitmq.consumers;

import dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static constants.RabbitMQConstants.QUEUE_PRODUCT_LOG;

@Component
@Log4j2
public class ProductConsumer {

    @RabbitListener(queues = { QUEUE_PRODUCT_LOG })
    public void consumer_product(ProductDTO productDTO) {
        log.info("Consumer received a message {}", productDTO);
    }



}
