package com.example.restkafkaproducer;

import com.example.restkafkaproducer.model.DummyObject;
import com.example.restkafkaproducer.model.NotThatDummyObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@SpringBootApplication
public class RestKafkaProducer {

    public static void main(String[] args) {
        SpringApplication.run(RestKafkaProducer.class, args);
    }

    @RestController
    public static class DummyController {

        private final DummyService dummyService;

        public DummyController(DummyService dummyService) {
            this.dummyService = dummyService;
        }

        @RequestMapping(value = "simpleEndpoint", method = POST)
        public NotThatDummyObject dummy(@RequestBody DummyObject dummyObject, @RequestParam("needDifferentResponse") boolean needDifferent) {
            return dummyService.dummy(dummyObject);
        }
    }

    @Service
    public static class DummyService {

        public NotThatDummyObject dummy(DummyObject dummyObject) {
            return new NotThatDummyObject("notThatDummy", dummyObject);
        }
    }
}
