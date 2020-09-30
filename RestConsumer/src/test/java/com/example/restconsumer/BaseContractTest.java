package com.example.restconsumer;

import com.example.restconsumer.RestConsumerApplication.MyController;
import com.example.restconsumer.model.DummyObject;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTest {


    @BeforeEach
    public void setup(){
        PodamFactory factory = new PodamFactoryImpl();
        DummyObject dummyObject = factory.manufacturePojo(DummyObject.class);
        RestConsumerApplication.DummyService dummyService = mock(RestConsumerApplication.DummyService.class);
        when(dummyService.callForDummyObject(any(), anyBoolean())).thenReturn(dummyObject);

        RestAssuredMockMvc.standaloneSetup(new MyController(dummyService));
    }

}
