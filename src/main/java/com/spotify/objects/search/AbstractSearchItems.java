package com.spotify.objects.search;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public abstract class AbstractSearchItems implements SpotifyObject {

    @SpotifyField
    private String href;

    @SpotifyField
    private int limit;

    @SpotifyOptional
    @SpotifyField
    private String next;

    @SpotifyField
    private int offset;

    @SpotifyOptional
    @SpotifyField
    private String previous;

    @SpotifyField
    private int total;

}

