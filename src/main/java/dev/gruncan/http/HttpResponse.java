package dev.gruncan.http;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.SpotifyRequestExecutor;

/**
 * Represent the response from a {@link HttpRequest}
 * <p>Created when calling {@link  HttpRequest#execute()}</p>
 *
 * @author Gruncan
 * @see HttpRequest
 * @see HttpMethod
 * @see SpotifyHttpServerProvider
 * @see SpotifyRequestExecutor
 * @see SpotifyResponse
 * @since 1.0.0
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
