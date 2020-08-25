package br.com.kafka.example.demo.producer;

import br.com.kafka.example.demo.producer.model.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestProducer testProducer;

    @PostMapping
    public void send(@RequestBody Test test) throws JsonProcessingException {
        testProducer.send(test);
    }
}