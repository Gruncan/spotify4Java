package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.tracks.Track;
import lombok.Getter;

@Getter
public class ArtistTrackPage extends AbstractSearchItems implements SpotifyObject {


    @SpotifyField(value = "items", canSkip = true)
    private Artist[] artist;

    @SpotifyField(value = "item", canSkip = true)
    private Track[] tracks;
}
