package br.com.kafka.example.demo.consumer;

import br.com.kafka.example.demo.producer.model.Test;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerTest {

    @KafkaListener(topics = "${topics.test}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(@Payload Test message) {
        log.info("Consumindo mensagem: " + message.toString());
    }
}