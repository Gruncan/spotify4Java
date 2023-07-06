package dev.gruncan.spotify.objects.shows;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class SavedShow implements SpotifyObject {

    @SpotifyField("added_at")
    private String addedAt;

    @SpotifyField
    private Show show;

}
