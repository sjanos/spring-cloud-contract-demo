package contracts.restkafkaproducer

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    label("send_dummy_message")
    outputMessage {
        sentTo("dummy_channel")
        body(
                "testString": $(consumer(anyNonBlankString()), producer("testString")),
                "testInteger": $(consumer(anyInteger()), producer(1234)),
        )
        headers {
            header("contentType", applicationJsonUtf8())
        }
    }
}