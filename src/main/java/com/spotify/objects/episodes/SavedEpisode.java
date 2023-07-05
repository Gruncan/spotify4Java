package com.spotify.objects.episodes;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class SavedEpisode implements SpotifyObject {


    @SpotifyField("added_at")
    private String addedAt;

    @SpotifyField
    private Episode episode;

}
