package dev.gruncan.spotify.webapi.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestContent;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import dev.gruncan.spotify.webapi.requests.util.SpotifyPositionObject;
import dev.gruncan.spotify.webapi.requests.util.SpotifyUriObject;
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
    private SpotifyUriObject contextUri;

    /**
     * An array of the Spotify track URIs to play
     */
    @SpotifyRequestContent
    private SpotifyUriObject[] uris;

    /**
     * Indicates from where in the context playback should start.
     * Only available when context_uri corresponds to an album or playlist object "position" is zero based and can't be negative.
     */
    @SpotifyRequestContent
    private SpotifyPositionObject offset;



}
