package com.example.restkafkaproducer;

import com.example.restkafkaproducer.model.DummyObject;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class DummyMessageProducer {

    private final Source source;

    public DummyMessageProducer(Source source) {
        this.source = source;
    }

    public void sendMessage(DummyObject dummyObject) {
        source.output().send(MessageBuilder.withPayload(dummyObject).build());
    }
}
