package com.spotify.requests;

import com.http.HttpResponse;
import com.json.JSONObject;
import com.spotify.SpotifyResponse;

/**
 * The request response from spotify, with already parsed JSON
 *
 * @see SpotifyResponse
 * @see SpotifyRequestExecutor
 * @see SpotifyRequest
 * @see JSONObject
 * @see HttpResponse
 */
public class RequestResponse {

    /**
     * The raw content of the spotify response in parsed json
     */
    private final JSONObject content;

    /**
     * The code of the spotify response
     */
    private final int code;

    /**
     * The message of the spotify response
     */
    private final String message;

    /**
     * Initializes the {@link RequestResponse}
     *
     * @param content The unchecked parsed json of spotify's response
     * @param code The of spotify's response
     * @param message The message of spotify's response
     */
    public RequestResponse(JSONObject content, int code, String message) {
        this.content = content;
        this.code = code;
        this.message = message;
    }

    /**
     * Returns the raw unchecked parsed json if {@code code == 200}
     *
     * @return The raw unchecked parsed {@link JSONObject}
     */
    public JSONObject getParsedJson() {
        return this.content;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
