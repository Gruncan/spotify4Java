package com.spotify.requests.me.player;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

/**
 * Get the list of objects that make up the user's queue.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/remove-albums-user">Spotify Docs</a>
 * <p>Serializes into {@link Album}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/player/queue", authorizations = Scope.USER_READ_PLAYBACK_STATE)
public class MyPlayerQueueGet implements SpotifyRequestVariant {

}
