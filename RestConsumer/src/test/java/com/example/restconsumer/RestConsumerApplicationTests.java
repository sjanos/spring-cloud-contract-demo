package com.example.restconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(classifier = "${stubrunner.environment}")
class RestConsumerApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Value("${dependencies.restproducer.url}")
    String value;

    @Test
    void testEndpointCallWithoutDifferenceRequest() throws Exception {
        mockMvc.perform(post("/dummy")
                .contentType(APPLICATION_JSON)
                .queryParam("needDifferentResponse", "false")
                .content("{ \"testString\":\"test\", \"testInteger\": 1234 }"))
                .andDo(print())
                .andExpect(content().json("{ \"testString\":\"test\", \"testInteger\": 1234 }", true))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }


    @Test
    void testEndpointCallWithDifferenceRequest() throws Exception {
        mockMvc.perform(post("/dummy")
                .contentType(APPLICATION_JSON)
                .param("needDifferentResponse", "true")
                .content("{ \"testString\":\"test\", \"testInteger\": 1234 }"))
                .andDo(print())
                .andExpect(jsonPath("$.testString").value(is("testStringInDummyDifferent")))
                .andExpect(jsonPath("$.testInteger").value(is(4321)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }
}