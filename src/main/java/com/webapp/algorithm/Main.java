package com.webapp.algorithm;

import com.spotify.objects.SpotifyImage;
import com.spotify.objects.SpotifyObject;

public class Main {


    public static void main(String[] args) {
        SpotifyImage[] spotifyObjects = new SpotifyImage[10];
        System.out.println(SpotifyObject.class.isAssignableFrom(spotifyObjects.getClass()));
    }


}
