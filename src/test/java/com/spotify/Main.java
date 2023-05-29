package com.spotify;

import com.spotify.objects.user.Profile;
import com.spotify.requests.users.UserProfileGet;

public class Main {


    public static void main(String[] args) {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();

        UserProfileGet us = new UserProfileGet();

        SpotifyResponse response = sc.executeRequest(us);

        System.out.println(response.getJsonObject().toString(4));

        Profile profile = response.getSerialisedObject();

        System.out.println(profile);
    }

}
