package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.albums.SimplifiedAlbum;
import com.spotify.objects.artists.SimplifiedArtist;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a album in a track
 *
 * @see SimplifiedAlbum
 * @see Track
 * @see SimplifiedArtist
 * @see SpotifyObject
 */
@Getter
@Setter
public class TrackAlbum extends SimplifiedAlbum implements SpotifyObject {

    /**
     * An array of {@link SimplifiedArtist} for a track album
     */
    @SpotifyField
    private SimplifiedArtist[] artists;
}
