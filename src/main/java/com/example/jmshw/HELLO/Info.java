package com.example.jmshw.HELLO;

import java.util.List;

//@Data
//@Entity
public class Info {
//    @Id
//    @GeneratedValue
//    private Long id;

    private String name;
    private List<String> condition;

    public Info(){}

    public Info(String name, List<String> condition) {
        this.name = name;
        this.condition = condition;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCondition() {
        return condition;
    }

    public void setCondition(List<String> condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        String message = " ";
        for(String string : condition) {
            message += string + ", ";
        }
        return message;
    }
}
