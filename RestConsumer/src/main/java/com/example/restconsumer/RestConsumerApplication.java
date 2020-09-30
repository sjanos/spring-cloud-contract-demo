package com.example.restconsumer;

import com.example.restconsumer.model.DummyObject;
import com.example.restconsumer.model.NotThatDummyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class RestConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

    @RestController
    public static class MyController {

        private final DummyService dummyService;

        @Autowired
        public MyController(DummyService dummyService) {
            this.dummyService = dummyService;
        }

        @RequestMapping("/dummy")
        public DummyObject dummyRequest(
                @RequestBody DummyObject dummyObject, @RequestParam("needDifferentResponse") boolean needDifferent) {
            return dummyService.callForDummyObject(dummyObject, needDifferent);
        }
    }

    @Service
    public static class DummyService {
        private final RestTemplate restTemplate = new RestTemplate();

        private final String serviceUrl;

        public DummyService(@Value("${dependencies.restproducer.url}") String serviceUrl) {
            this.serviceUrl = serviceUrl;
        }

        public DummyObject callForDummyObject(DummyObject dummyObject, boolean needDifferent) {
            return restTemplate.postForObject(serviceUrl + "/simpleEndpoint?needDifferentResponse=" + needDifferent, dummyObject, NotThatDummyObject.class).getDummyObject();
        }
    }

}
