package com.spotify.requests.users;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Create a playlist for a Spotify user. (The playlist will be empty until you add tracks.)
 * <a href="https://developer.spotify.com/documentation/web-api/reference/create-playlist">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "users", end = "playlists",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.POST)
public class UserPlaylistCreatePost implements SpotifyRequestVariant {

    /**
     * The user's Spotify user ID.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * The name for the new playlist. This name does not need to be unique; a user may have several playlists with the same name.
     */
    @SpotifyRequestContent
    private final String name;

    /**
     * Defaults to true. If true the playlist will be public, if false it will be private.
     * To be able to create private playlists, the user must have granted the playlist-modify-private
     */
    @SpotifyRequestContent("public")
    private boolean isPublic;

    /**
     * Defaults to false. If true the playlist will be collaborative. Note: to create a collaborative playlist you must also set public to false.
     * To create collaborative playlists you must have granted playlist-modify-private and playlist-modify-public
     */
    @SpotifyRequestContent("collaborative")
    private boolean isCollaborative;

    /**
     * value for playlist description as displayed in Spotify Clients and in the Web API.
     */
    @SpotifyRequestContent
    private String description;

    /**
     * Initializes the {@link UserPlaylistCreatePost} request
     * @param id The Spotify ID of the user.
     * @param name The name of the playlist
     */
    public UserPlaylistCreatePost(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
