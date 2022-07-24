package com.spingcloudstreams.demo.kafka.producer;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestProducer {

    @Value("${topic}")
    private String topic;

    private final  KafkaTemplate<String,String> kafkaTemplate;

    public  void sendMessage(String message) {
        this.kafkaTemplate.send(this.topic,message);
    }
}
