package com.spotify.requests.me.player;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import com.spotify.requests.util.SpotifyPositionObject;
import lombok.Setter;

/**
 * Start a new context or resume current playback on the user's active device.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/start-a-users-playback">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/player/play", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerResumePut implements SpotifyRequestVariant {

    /**
     * The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @SpotifyRequestField("device_id")
    private String id;

    /**
     * Spotify URI of the context to play. Valid contexts are albums, artists & playlists.
     */
    @SpotifyRequestContent("context_uri")
    private String contextUri;

    /**
     * An array of the Spotify track URIs to play
     */
    @SpotifyRequestContent
    private String[] uris;

    /**
     * Indicates from where in the context playback should start.
     * Only available when context_uri corresponds to an album or playlist object "position" is zero based and can't be negative.
     */
    @SpotifyRequestContent
    private SpotifyPositionObject offset;



}
