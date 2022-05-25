package com.spotify.requests;

public class RequestQuery<T> {

    private final String key;
    private final T value;


    public RequestQuery(String key, T value) {
        this.key = key;
        this.value = value;
    }


    public String getPair() {
        return String.format("%s=%s", this.key, this.value.toString());
    }


    public String getKey() {
        return this.key;
    }

    public Class<?> getQueryType() {
        return this.value.getClass();
    }


}
