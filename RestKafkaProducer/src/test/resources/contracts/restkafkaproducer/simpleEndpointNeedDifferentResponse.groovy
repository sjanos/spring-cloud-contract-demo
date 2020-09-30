package contracts.restkafkaproducer


import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        urlPath('/simpleEndpoint') {
            queryParameters {
                parameter 'needDifferentResponse': true
            }
        }

        body(
                "testString": $(consumer(anyNonBlankString()), producer("testString")),
                "testInteger": $(consumer(anyInteger()), producer(1234)),
        )
        headers {
            contentType applicationJson()
        }
    }
    response {
        status 200
        body(
                "testString": $(consumer("testStringDifferent"), producer(anyNonBlankString())),
                "dummyObject": [
                        "testString" : $(consumer("testStringInDummyDifferent"), producer(anyNonBlankString())),
                        "testInteger": $(consumer(4321), producer(anyInteger()))
                ]
        )
        headers {
            contentType applicationJson()
        }
    }
}