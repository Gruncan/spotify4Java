package dev.gruncan.spotify.objects.tracks;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class SavedTrack implements SpotifyObject {

    @SpotifyField("added_at")
    private String addedAt;

    @SpotifyField
    private Track track;


}
