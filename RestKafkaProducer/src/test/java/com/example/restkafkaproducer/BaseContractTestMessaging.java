package com.example.restkafkaproducer;

import com.example.restkafkaproducer.model.DummyObject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestKafkaProducer.class)
@AutoConfigureMessageVerifier
public class BaseContractTestMessaging {

    @Autowired
    private DummyMessageProducer dummyMessageProducer;

    public void sendMessage() {
        dummyMessageProducer.sendMessage(new DummyObject("testString", 1234));
    }

}
