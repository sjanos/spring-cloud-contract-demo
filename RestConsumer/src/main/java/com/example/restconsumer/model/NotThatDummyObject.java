package com.example.restconsumer.model;

public class NotThatDummyObject {

    private String testString;
    private DummyObject dummyObject;

    public NotThatDummyObject() {
    }

    public NotThatDummyObject(String testString, DummyObject dummyObject) {
        this.testString = testString;
        this.dummyObject = dummyObject;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public DummyObject getDummyObject() {
        return dummyObject;
    }

    public void setDummyObject(DummyObject dummyObject) {
        this.dummyObject = dummyObject;
    }
}