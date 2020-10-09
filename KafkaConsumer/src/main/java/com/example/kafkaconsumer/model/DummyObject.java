package com.example.kafkaconsumer.model;

public class DummyObject {

    private String testString;
    private Integer testInteger;

    public DummyObject() {
    }

    public DummyObject(String testString, Integer testInteger) {
        this.testString = testString;
        this.testInteger = testInteger;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public Integer getTestInteger() {
        return testInteger;
    }

    public void setTestInteger(Integer testInteger) {
        this.testInteger = testInteger;
    }
}