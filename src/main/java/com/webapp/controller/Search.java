package com.webapp.controller;

public class Search {

    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Search{" +
                "value='" + value + '\'' +
                '}';
    }
}
