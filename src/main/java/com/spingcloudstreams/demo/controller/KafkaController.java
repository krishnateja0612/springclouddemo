package com.spingcloudstreams.demo.controller;

import com.spingcloudstreams.demo.kafka.producer.TestProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final TestProducer testProducer;

    @PostMapping("/send/{message}")
    public ResponseEntity<String> sendMessageToKafka(@PathVariable("message") String message){
        testProducer.sendMessage(message);
        return ResponseEntity.ok(message);
    }
}
