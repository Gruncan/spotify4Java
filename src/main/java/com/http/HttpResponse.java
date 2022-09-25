package com.http;

public class HttpResponse {


    private final int code;
    private final String content;
    private final String message;


    public HttpResponse(int code, String content, String message) {
        this.code = code;
        this.content = content;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    public String getMessage() {
        return message;
    }
}
