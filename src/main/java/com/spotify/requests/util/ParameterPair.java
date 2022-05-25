package com.spotify.requests.util;

public class ParameterPair {


    private final String key;
    private final Class<?> classType;


    public ParameterPair(String key, Class<?> classType) {
        this.key = key;
        this.classType = classType;
    }


    public String getKey() {
        return this.key;
    }

    public Class<?> getClassType() {
        return this.classType;
    }


}
