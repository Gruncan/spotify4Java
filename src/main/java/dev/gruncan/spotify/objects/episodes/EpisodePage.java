package dev.gruncan.spotify.objects.episodes;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;

@Getter
public class EpisodePage extends AbstractSearchItems implements SpotifyObject {

    @SpotifyField
    private SavedEpisode[] items;

}
