package dev.gruncan.http;

public class ClientTest {


    public static void main(String[] args) {
        //Tests http request on a given server

        HttpRequest httpRequest = new HttpRequest("http://127.0.0.1:8889/test/", HttpMethod.POST);
        httpRequest.addRequestHeader("Content-Type", "application/json");
        httpRequest.addContent("{\"t\" : true}");

        HttpResponse httpResponse = httpRequest.execute();

        System.out.printf("Code:  %d  Message  %s    Content: %s%n", httpResponse.getCode(),
                httpResponse.getMessage(), httpResponse.getContent());


    }

}
