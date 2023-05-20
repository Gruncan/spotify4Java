package com.spotify.objects.genres;

import com.spotify.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Genre implements SpotifyObject {


    private String[] genres;

}
