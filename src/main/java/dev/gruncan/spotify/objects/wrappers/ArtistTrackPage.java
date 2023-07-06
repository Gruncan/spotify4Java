package dev.gruncan.spotify.objects.wrappers;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.artists.Artist;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.objects.tracks.Track;
import lombok.Getter;

@Getter
public class ArtistTrackPage extends AbstractSearchItems implements SpotifyObject {


    @SpotifyField(value = "items", canSkip = true)
    private Artist[] artist;

    @SpotifyField(value = "item", canSkip = true)
    private Track[] tracks;
}
