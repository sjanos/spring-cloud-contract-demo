package com.example.restkafkaproducer;

import com.example.restkafkaproducer.RestKafkaProducer.DummyController;
import com.example.restkafkaproducer.RestKafkaProducer.DummyService;
import com.example.restkafkaproducer.model.DummyObject;
import com.example.restkafkaproducer.model.NotThatDummyObject;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@AutoConfigureMessageVerifier
public class BaseContractTest {


    @BeforeEach
    public void setup() {
        PodamFactory factory = new PodamFactoryImpl();

        DummyObject dummyObject = new DummyObject();
        dummyObject.setTestString("testStringInDummy");
        dummyObject.setTestInteger(1234);

        NotThatDummyObject notThatDummyObject = new NotThatDummyObject();
        notThatDummyObject.setTestString("testString");
        notThatDummyObject.setDummyObject(dummyObject);


        DummyService dummyService = mock(DummyService.class);
        when(dummyService.dummy(any())).thenReturn(notThatDummyObject);

        RestAssuredMockMvc.standaloneSetup(new DummyController(dummyService));
    }

}
