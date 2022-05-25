package com.spotify.requests.authentication;

public class AuthenticationRequests {


    private static final String URL = "https://accounts.spotify.com/authorize";
    private static String CLIENT_ID;
    private static String REDIRECT_URL;


    private static AuthenticationRequests instance = null;


    private AuthenticationRequests() {

    }

    public static AuthenticationRequests getInstance() {
        if (instance == null)
            instance = new AuthenticationRequests();

        return instance;
    }


    public String getRequestUrl() {
        return null;
    }


}
