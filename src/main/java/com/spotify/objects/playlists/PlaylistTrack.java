package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a track or episode in a playlist
 *
 * @see PlaylistTracksSearch
 * @see PlaylistContributor
 * @see SpotifyObject
 */
@Getter
@Setter
public class PlaylistTrack implements SpotifyObject {

    /**
     * The date and time the track or episode was added. Note: some very old playlists may return null in this field.
     */
    @SpotifyField
    private String addedAt;

    /**
     * The Spotify user who added the track or episode. Note: some very old playlists may return null in this field.
     */
    @SpotifyField
    private PlaylistContributor addedBy;

    /**
     * Whether this track or episode is a local file or not.
     */
    @SpotifyField("is_local")
    private boolean isLocal;

    /**
     * Information about the track or episode.
     */
    //todo optional field can be more than one thing
    private SpotifyObject oneof;

}
