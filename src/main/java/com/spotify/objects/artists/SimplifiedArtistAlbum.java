package com.spotify.objects.artists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.albums.SimplifiedAlbum;
import com.spotify.requests.artists.ArtistsAlbumsGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a SimplifiedArtistAlbum<br>
 * Used with {@link ArtistsAlbumsGet}
 *
 * @see SimplifiedAlbum
 * @see SimplifiedArtist
 * @see SpotifyObject
 */
@Getter
@Setter
public class SimplifiedArtistAlbum extends SimplifiedAlbum implements SpotifyObject {

    /**
     * The field is present when getting an artist's albums. Compare to album_type this field represents relationship between the artist and the album.
     */
    @SpotifyOptional
    @SpotifyField("album_group")
    private String albumGroup;

    /**
     * The artists of the album. Each artist object includes a link in href to more detailed information about the artist.
     */
    @SpotifyField("artists")
    private SimplifiedArtist[] simplifiedArtists;

}
