package com.example.kafkaconsumer.messaging;

import com.example.kafkaconsumer.model.DummyObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DummyMessageRepository {

    Map<String, DummyObject> dummyObjectMap = new HashMap<>();

    public DummyObject getDummyMessage(String messageKey) {
        return dummyObjectMap.get(messageKey);
    }

    public void saveDummyMessage(String messageKey, DummyObject dummyObject) {
        dummyObjectMap.put(messageKey, dummyObject);
    }
}
