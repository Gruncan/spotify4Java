package com.spotify.json;

public class JsonObject {

    private final String rawJson;

    public JsonObject(String json) {
        this.rawJson = json;
    }


    @Override
    public String toString() {
        return this.rawJson;
    }

}
