/*
 * Written by Gruncan for spotify4Java (https://github.com/Gruncan/spotify4Java/)
 *  21/04/23
 */
package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.artists.SimplifiedArtist;
import com.spotify.objects.wrappers.Country;
import com.spotify.objects.wrappers.SpotifyCopyright;
import com.spotify.objects.wrappers.SpotifyExternalID;
import com.spotify.objects.wrappers.SpotifyImage;
import com.spotify.objects.artists.ArtistAlbums;
import com.spotify.requests.artists.ArtistsAlbumsGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedAlbum object<br>
 * Reduces repetition and is used in responses from {@link ArtistsAlbumsGet}
 * @see Album
 * @see ArtistAlbums
 * @see ArtistsAlbumsGet
 */
@Getter
@Setter
public class SimplifiedAlbum implements SpotifyObject {

    @SpotifyField("album_type")
    private String albumType;

    @SpotifyField("total_tracks")
    private int totalTracks;

    @SpotifyOptional
    @SpotifyField("available_markets")
    private Country[] markets;

    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalIDs;

    @SpotifyField
    private String href;

    @SpotifyField
    private String id;

    @SpotifyField
    private SpotifyImage[] images;

    @SpotifyField
    private String name;

    @SpotifyField("release_date")
    private String releaseDate;

    @SpotifyField("release_date_precision")
    private String releaseDatePrecision;

    @SpotifyOptional
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restrictions;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

    @SpotifyOptional
    @SpotifyField
    private SpotifyCopyright[] copyrights;

    @SpotifyOptional
    @SpotifyField("external_ids")
    private SpotifyExternalID externalIDS;

    @SpotifyOptional
    @SpotifyField
    private String[] genres;

    @SpotifyOptional
    @SpotifyField
    private String label;

    @SpotifyOptional
    @SpotifyField
    private int popularity;

    @SpotifyOptional
    @SpotifyField("album_group")
    private String albumGroup;

    @SpotifyField("artists")
    private SimplifiedArtist[] simplifiedArtists;
}
