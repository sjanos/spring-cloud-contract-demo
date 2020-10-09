package com.example.kafkaconsumer;

import com.example.kafkaconsumer.messaging.DummyMessageRepository;
import com.example.kafkaconsumer.model.DummyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(classifier = "${stubrunner.environment}")
class KafkaConsumerApplicationTest {

    @Autowired
    private StubTrigger stubTrigger;

    @Autowired
    private DummyMessageRepository dummyMessageRepository;

    @Test
    public void shouldReceiveMessage() {

        final UUID uuid = UUID.randomUUID();

        stubTrigger.trigger("send_dummy_message");

        final DummyObject dummyObject = dummyMessageRepository.getDummyMessage(uuid.toString());

        assertThat(dummyObject.getTestInteger()).isEqualTo(1234);
        assertThat(dummyObject.getTestString()).isEqualTo("testString");

    }


}