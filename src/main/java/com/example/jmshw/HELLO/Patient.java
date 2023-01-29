package com.example.jmshw.HELLO;

public class Patient {
    private String name;
    private String condition;

    public Patient(){}

    public Patient(String name, String condition) {
        this.name = name;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return String.format("Patient{Name=%s, Condition=%s}", getName(), getCondition());
    }
}
