package com.example.kafkaconsumer.messaging;

import com.example.kafkaconsumer.model.DummyObject;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class DummyMessageListener {

    private final DummyMessageRepository dummyMessageRepository;

    public DummyMessageListener(DummyMessageRepository dummyMessageRepository) {
        this.dummyMessageRepository = dummyMessageRepository;
    }

    @StreamListener(Sink.INPUT)
    public void receiveDummyMessage(DummyObject dummyObject) {
        dummyMessageRepository.saveDummyMessage(dummyObject.getTestString(), dummyObject);
    }
}