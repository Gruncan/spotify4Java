package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistTrack implements SpotifyObject {

    @SpotifyField
    private String addedAt;

    @SpotifyField
    private PlaylistContributor addedBy;

    @SpotifyField("is_local")
    private boolean isLocal;

    //todo optional field can be more than one thing
    private SpotifyObject oneof;

}
