package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.webapi.requests.me.*;
import dev.gruncan.spotify.webapi.requests.me.albums.MyAlbumsDelete;
import dev.gruncan.spotify.webapi.requests.me.albums.MyAlbumsGet;
import dev.gruncan.spotify.webapi.requests.me.albums.MyAlbumsPut;
import dev.gruncan.spotify.webapi.requests.me.albums.MyAlbumsSavedGet;
import dev.gruncan.spotify.webapi.requests.me.audiobooks.MyAudiobooksDelete;
import dev.gruncan.spotify.webapi.requests.me.audiobooks.MyAudiobooksGet;
import dev.gruncan.spotify.webapi.requests.me.audiobooks.MyAudiobooksPut;
import dev.gruncan.spotify.webapi.requests.me.audiobooks.MyAudiobooksSavedGet;
import dev.gruncan.spotify.webapi.requests.me.player.*;
import dev.gruncan.spotify.webapi.requests.me.playlists.MyPlaylistsGet;
import dev.gruncan.spotify.webapi.requests.me.shows.MyShowsDelete;
import dev.gruncan.spotify.webapi.requests.me.shows.MyShowsGet;
import dev.gruncan.spotify.webapi.requests.me.shows.MyShowsPut;
import dev.gruncan.spotify.webapi.requests.me.shows.MyShowsSavedGet;
import dev.gruncan.spotify.webapi.requests.me.tracks.MyTracksDelete;
import dev.gruncan.spotify.webapi.requests.me.tracks.MyTracksGet;
import dev.gruncan.spotify.webapi.requests.me.tracks.MyTracksPut;
import dev.gruncan.spotify.webapi.requests.me.tracks.MyTracksSavedGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyUrlTests extends AbstractUrlTest {

    @Test
    public void myFollowedArtistsGetTestUrl(){
        SpotifyRequestVariant request = new MyFollowedArtistsGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myFollowingPersonGetTestUrl(){
        SpotifyRequestVariant request = new MyFollowingPersonGet("artist",
                "2CIMQHirSU0MQqyYHq0eOx","57dN52uHvrHOxijzpIgu3E","1vCWHaC5f2uS3yhpwWbIA6");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myFollowPersonPutTestUrl(){
        SpotifyRequestVariant request = new MyFollowPersonPut("artist",
                "2CIMQHirSU0MQqyYHq0eOx","57dN52uHvrHOxijzpIgu3E","1vCWHaC5f2uS3yhpwWbIA6");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myProfileGetTestUrl(){
        SpotifyRequestVariant request = new MyProfileGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myTopInfoTestUrl(){
        SpotifyRequestVariant request = new MyTopInfo("artists");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myUnfollowPersonDeleteTestUrl(){
        SpotifyRequestVariant request = new MyUnfollowPersonDelete("artist",
                "2CIMQHirSU0MQqyYHq0eOx","57dN52uHvrHOxijzpIgu3E","1vCWHaC5f2uS3yhpwWbIA6");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }


    /* ALBUMS */

    @Test
    public void myAlbumsDeleteTestUrl(){
        SpotifyRequestVariant request = new MyAlbumsDelete("382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo", "2noRn2Aes5aoNVsU6iWThc");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myAlbumsGetTestUrl(){
        SpotifyRequestVariant request = new MyAlbumsGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myAlbumsPutTestUrl(){
        SpotifyRequestVariant request = new MyAlbumsPut("382ObEPsp2rxGrnsizN5TX","1A2GTWGtFfWp7KSQTwWOyo","2noRn2Aes5aoNVsU6iWThc");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myAlbumsSavedGetTestUrl(){
        SpotifyRequestVariant request = new MyAlbumsSavedGet("382ObEPsp2rxGrnsizN5TX","1A2GTWGtFfWp7KSQTwWOyo","2noRn2Aes5aoNVsU6iWThc");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }


    /* AUDIOBOOKS */

    @Test
    public void myAudiobooksDeleteTestUrl(){
        SpotifyRequestVariant request = new MyAudiobooksDelete("18yVqkdbdRvS24c0Ilj2ci","1HGw3J3NxZO1TP1BTtVhpZ","7iHfbu1YPACw6oZPAFJtqe");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myAudiobooksGetTestUrl(){
        SpotifyRequestVariant request = new MyAudiobooksGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myAudiobooksPutTestUrl(){
        SpotifyRequestVariant request = new MyAudiobooksPut("18yVqkdbdRvS24c0Ilj2ci","1HGw3J3NxZO1TP1BTtVhpZ","7iHfbu1YPACw6oZPAFJtqe");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myAudiobooksSavedGetTestUrl(){
        SpotifyRequestVariant request = new MyAudiobooksSavedGet("18yVqkdbdRvS24c0Ilj2ci","1HGw3J3NxZO1TP1BTtVhpZ","7iHfbu1YPACw6oZPAFJtqe");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    /* PLAYER */

    @Test
    public void myPlayerCurrentlyPlayingGetTestUrl(){
        SpotifyRequestVariant request = new MyPlayerCurrentlyPlayingGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myPlayerDevicesGetTestUrl(){
        SpotifyRequestVariant request = new MyPlayerDevicesGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myPlayerGetTestUrl(){
        SpotifyRequestVariant request = new MyPlayerGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

//    @Test
//    public void myPlayerNextPostTestUrl(){
//        SpotifyRequestVariant request = new MyPlayerNextPost();
//        String actualUrl = super.client.getBuiltURL(request);
//        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
//    }

    @Test
    public void myPlayerPausePutTestUrl(){
        SpotifyRequestVariant request = new MyPlayerPausePut();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

//    @Test
//    public void myPlayerPreviousPostTestUrl(){
//        SpotifyRequestVariant request = new MyPlayerPreviousPost();
//        String actualUrl = super.client.getBuiltURL(request);
//        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
//    }

    @Test
    public void myPlayerQueueGetTestUrl(){
        SpotifyRequestVariant request = new MyPlayerQueueGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

//    @Test
//    public void myPlayerQueuePostTestUrl(){
//        SpotifyRequestVariant request = new MyPlayerQueuePost("spotify:track:4iV5W9uYEdYUVa79Axb7Rh");
//        String actualUrl = super.client.getBuiltURL(request);
//        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
//    }

    @Test
    public void myPlayerRecentlyPlayedGetTestUrl(){
        SpotifyRequestVariant request = new MyPlayerRecentlyPlayedGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myPlayerRepeatPutTestUrl(){
        SpotifyRequestVariant request = new MyPlayerRepeatPut("context");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myPlayerResumePutTestUrl(){
        SpotifyRequestVariant request = new MyPlayerResumePut();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myPlayerSeekPutTestUrl(){
        SpotifyRequestVariant request = new MyPlayerSeekPut(25000);
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myPlayerSetVolumePutTestUrl(){
        SpotifyRequestVariant request = new MyPlayerSetVolumePut(50);
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myPlayerToggleShufflePutTestUrl(){
        SpotifyRequestVariant request = new MyPlayerToggleShufflePut(true);
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myPlayerTransferPutTestUrl(){
        SpotifyRequestVariant request = new MyPlayerTransferPut("74ASZWbe4lXaubB36ztrGX");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }





    /* PLAYLIST */
    @Test
    public void myMyPlaylistsGetTestUrl(){
        SpotifyRequestVariant request = new MyPlaylistsGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    /* SHOWS */
    @Test
    public void myShowsDeleteTestUrl(){
        SpotifyRequestVariant request = new MyShowsDelete("5CfCWKI5pZ28U0uOzXkDHe","5as3aKmN2k11yfDDDSrvaZ");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myShowsGetTestUrl(){
        SpotifyRequestVariant request = new MyShowsGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myShowsPutTestUrl(){
        SpotifyRequestVariant request = new MyShowsPut("5CfCWKI5pZ28U0uOzXkDHe","5as3aKmN2k11yfDDDSrvaZ");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myShowsSavedGetTestUrl(){
        SpotifyRequestVariant request = new MyShowsSavedGet("5CfCWKI5pZ28U0uOzXkDHe","5as3aKmN2k11yfDDDSrvaZ");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    /* TRACKS */
    @Test
    public void myTracksDeleteTestUrl(){
        SpotifyRequestVariant request = new MyTracksDelete("7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myTracksGetTestUrl(){
        SpotifyRequestVariant request = new MyTracksGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myTracksPutTestUrl(){
        SpotifyRequestVariant request = new MyTracksPut("7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void myTracksSavedGetTestUrl(){
        SpotifyRequestVariant request = new MyTracksSavedGet("7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
