package contracts.restkafkaproducer.http


import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        urlPath('/simpleEndpoint') {
            queryParameters {
                parameter 'needDifferentResponse': false
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
                "testString": $(consumer("testStringInWrapper"), producer(anyNonBlankString())),
                "dummyObject": [
                        "testString" : $(consumer(fromRequest().body('$.testString')), producer(anyNonBlankString())),
                        "testInteger": $(consumer(fromRequest().body('$.testInteger')), producer(anyInteger()))
                ]
        )
        headers {
            contentType applicationJson()
        }
    }
}