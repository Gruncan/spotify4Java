package com.spotify.objects.player;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class SpotifyDeviceArray implements SpotifyObject {


    @SpotifyField
    private SpotifyDevice[] devices;

}
