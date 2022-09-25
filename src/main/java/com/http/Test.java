package com.http;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {


        HttpRequest httpRequest = new HttpRequest("http://127.0.0.1:8889/test/", HttpMethod.POST);
        httpRequest.addRequestHeader("Content-Type", "application/json");
        httpRequest.addContent("{\"t\" : true}");

        HttpResponse httpResponse = httpRequest.execute();

        System.out.printf("Code:  %d  Message  %s    Content: %s%n", httpResponse.getCode(),
                httpResponse.getMessage(), httpResponse.getContent());


    }

}
