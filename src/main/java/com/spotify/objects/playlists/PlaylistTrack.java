package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.episodes.Episode;
import com.spotify.objects.tracks.Track;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a track or episode in a playlist
 *
 * @see PlaylistTracksSearch
 * @see PlaylistContributor
 * @see SpotifyObject
 */
@Getter
@Setter
@ToString
public class PlaylistTrack implements SpotifyObject {

    /**
     * The date and time the track or episode was added. Note: some very old playlists may return null in this field.
     */
    @SpotifyField("added_at")
    private String addedAt;

    /**
     * The Spotify user who added the track or episode. Note: some very old playlists may return null in this field.
     */
    @SpotifyField("added_by")
    private PlaylistContributor addedBy;

    /**
     * Whether this track or episode is a local file or not.
     */
    @SpotifyField("is_local")
    private boolean isLocal;

    /**
     * Information about the track
     */
    @SpotifyOptional
    @SpotifyField
    private Track track;

    /**
     * Information about the episode.
     */
    @SpotifyOptional
    @SpotifyField
    private Episode episode;

}
