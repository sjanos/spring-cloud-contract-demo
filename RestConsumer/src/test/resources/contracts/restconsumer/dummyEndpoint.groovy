package contracts.restconsumer


import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        urlPath('/dummy') {
            queryParameters {
                parameter 'needDifferentResponse': $(consumer(anyBoolean()), producer(true))
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
                "testString": $(consumer("testString"), producer(anyNonBlankString())),
                "testInteger": $(consumer(1234), producer(anyInteger()))
        )
        headers {
            contentType applicationJson()
        }
    }
}