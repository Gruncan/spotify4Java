package com.webapp.controller;

public class Search {

    private String value;


    public String getValue() {
        return this.value == null ? null : value.replace(" ", "%20");
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
