package com.spotify.requests;

import com.json.JSONObject;

public class RequestResponse {


    private final JSONObject content;
    private final int code;
    private final String message;


    public RequestResponse(JSONObject content, int code, String message) {
        this.content = content;
        this.code = code;
        this.message = message;
    }


    public JSONObject ok() {
        if (code == 200)
            return this.content;
        else
            return null;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }


}
