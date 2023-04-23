/*
 * Written by Gruncan for spotify4Java (https://github.com/Gruncan/spotify4Java/)
 *  25/09/22
 */
package com.http;

import com.spotify.requests.AbstractRequest;
import com.spotify.SpotifyResponse;

/**
 * Represent the response from a {@link HttpRequest}
 * <p>Created when calling {@link  HttpRequest#execute()}</p>
 * @see HttpRequest
 * @see HttpMethod
 * @see SpotifyHttpServerProvider
 * @see AbstractRequest
 * @see SpotifyResponse
 */
public class HttpResponse {


    private final int code;
    private final String content;
    private final String message;

    /**
     * Initializes a {@link HttpResponse}
     * @param code The code of the response
     * @param content The content of the response, can be {@code null}
     * @param message The response message of the response
     */
    public HttpResponse(int code, String content, String message) {
        this.code = code;
        this.content = content;
        this.message = message;
    }


    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getMessage() {
        return this.message;
    }
}
