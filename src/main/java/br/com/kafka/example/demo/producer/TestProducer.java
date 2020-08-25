package br.com.kafka.example.demo.producer;

import br.com.kafka.example.demo.producer.model.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TestProducer {

    @Value("${topics.test}")
    private String topic;

    private final KafkaTemplate<String, Test> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public void send(final Test test) throws JsonProcessingException {
        kafkaTemplate.send(topic, test);
    }
}
