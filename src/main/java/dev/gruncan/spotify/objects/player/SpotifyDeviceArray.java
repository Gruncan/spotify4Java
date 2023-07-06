package dev.gruncan.spotify.objects.player;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class SpotifyDeviceArray implements SpotifyObject {


    @SpotifyField
    private SpotifyDevice[] devices;

}
