package contracts.restkafkaproducer.messaging

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    label("send_dummy_message")
    outputMessage {
        sentTo($(consumer("input"), producer("output")))
        input {
            triggeredBy("sendMessage()")
        }
        body(
                "testString": "testString",
                "testInteger": 1234,
        )
        headers {
            header("contentType", applicationJson())
        }
    }
}