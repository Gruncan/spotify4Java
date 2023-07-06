package dev.gruncan.spotify.objects.episodes;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class SavedEpisode implements SpotifyObject {


    @SpotifyField("added_at")
    private String addedAt;

    @SpotifyField
    private Episode episode;

}
