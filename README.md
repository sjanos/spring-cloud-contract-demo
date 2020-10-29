# SPRING CLOUD CONTACT DEMO

* Our end-to-end test is not lightning-speed fast because it requires a lot of setups and makes sure that all other third parties are up, running and setup correctly, which on many occasion is not, and it causes a few problems and frustration.
* It is also challenging to track changes of one service and impact on another one.
* Spring Cloud contract helps in this case by providing a contract between services.
* Contract is a set of agreed interactions between services.
* It allows you to test consumers and provider of the contract independently. 
* Spring Cloud Contract owners believe that this is a way to move TDD to the level of software architecture.


## Where it can be useful in OM
- Between our services
- Between us and other teams like Checkout -> Order Taker
- It works well on Rest endpoints and Kafka endpoint

## Advantages:
* It gives fast-feedback to verify the integration between microservices, and increase confidence without running all services and their dependencies.
* It reduces an amount end-to-end test needed. It is not a replacement for an end-to-end test.
* Easier for people familiar with TDD, Groovy and Wiremock
* It is not an API documentation

## Disadvantages:
* Groovy
* Learning curve is annoying in the beginning.

## Alternatives:
*  Pact framework is used in some teams in Sainsbury's universe a.

## Resources:
0. Introduction to Spring Cloud Contract By Andrew Morgan
0. https://spring.io/guides/gs/contract-rest/
0. https://spring.io/projects/spring-cloud-contract

This project is a simple Kafka example.
