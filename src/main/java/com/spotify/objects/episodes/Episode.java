package com.spotify.objects.episodes;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.shows.Show;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Episode extends SimplifiedEpisode {


    @SpotifyField
    private Show show;

}
