package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import dev.gruncan.spotify.requests.me.*;
import dev.gruncan.spotify.requests.me.albums.MyAlbumsDelete;
import dev.gruncan.spotify.requests.me.albums.MyAlbumsGet;
import dev.gruncan.spotify.requests.me.albums.MyAlbumsPut;
import dev.gruncan.spotify.requests.me.albums.MyAlbumsSavedGet;
import dev.gruncan.spotify.requests.me.audiobooks.MyAudiobooksDelete;
import dev.gruncan.spotify.requests.me.audiobooks.MyAudiobooksGet;
import dev.gruncan.spotify.requests.me.audiobooks.MyAudiobooksPut;
import dev.gruncan.spotify.requests.me.audiobooks.MyAudiobooksSavedGet;
import dev.gruncan.spotify.requests.me.episodes.MyEpisodesDelete;
import dev.gruncan.spotify.requests.me.episodes.MyEpisodesGet;
import dev.gruncan.spotify.requests.me.episodes.MyEpisodesPut;
import dev.gruncan.spotify.requests.me.episodes.MyEpisodesSavedGet;
import dev.gruncan.spotify.requests.me.player.*;
import dev.gruncan.spotify.requests.me.playlists.MyPlaylistsGet;
import dev.gruncan.spotify.requests.me.shows.MyShowsDelete;
import dev.gruncan.spotify.requests.me.shows.MyShowsGet;
import dev.gruncan.spotify.requests.me.shows.MyShowsPut;
import dev.gruncan.spotify.requests.me.shows.MyShowsSavedGet;
import dev.gruncan.spotify.requests.me.tracks.MyTracksDelete;
import dev.gruncan.spotify.requests.me.tracks.MyTracksGet;
import dev.gruncan.spotify.requests.me.tracks.MyTracksPut;
import dev.gruncan.spotify.requests.me.tracks.MyTracksSavedGet;
import dev.gruncan.spotify.requests.util.RestrictedType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyConnectionTests extends AbstractConnectionTest {

    /* ** */
    /* ME */
    /* ** */
    @Test
    @Tag("NetworkTest")
    public void myFollowedArtistsGetTest() {
        SpotifyRequestVariant request = new MyFollowedArtistsGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myFollowingPersonGetTest() {
        SpotifyRequestVariant request = new MyFollowingPersonGet("artist",
                "2CIMQHirSU0MQqyYHq0eOx","57dN52uHvrHOxijzpIgu3E","1vCWHaC5f2uS3yhpwWbIA6");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myFollowPersonPutTest() {
        SpotifyRequestVariant request = new MyFollowPersonPut("aritst",
                "2CIMQHirSU0MQqyYHq0eOx","57dN52uHvrHOxijzpIgu3E","1vCWHaC5f2uS3yhpwWbIA6");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myProfileGetTest() {
        SpotifyRequestVariant request = new MyProfileGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myTopInfoTest() {
        SpotifyRequestVariant request = new MyTopInfo(RestrictedType.ARTISTS);
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myUnfollowPersonDeleteTest() {
        SpotifyRequestVariant request = new MyUnfollowPersonDelete("artist",
                "2CIMQHirSU0MQqyYHq0eOx","57dN52uHvrHOxijzpIgu3E","1vCWHaC5f2uS3yhpwWbIA6");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }
    
    
    /* ********* */
    /* ME/ALBUMS */
    /* ********* */
    @Test
    @Tag("NetworkTest")
    public void myAlbumsDeleteTest() {
        SpotifyRequestVariant request = new MyAlbumsDelete(
                "382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo", "2noRn2Aes5aoNVsU6iWThc");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myAlbumsGetTest() {
        SpotifyRequestVariant request = new MyAlbumsGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myAlbumsPutTest() {
        SpotifyRequestVariant request = new MyAlbumsPut(
                "382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo", "2noRn2Aes5aoNVsU6iWThc");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myAlbumsSavedGetTest() {
        SpotifyRequestVariant request = new MyAlbumsSavedGet(
                "382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo", "2noRn2Aes5aoNVsU6iWThc");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    
    /* ************* */
    /* ME/AUDIOBOOKS */
    /* ************* */
    @Test
    @Tag("NetworkTest")
    public void myAudiobooksDeleteTest() {
        SpotifyRequestVariant request = new MyAudiobooksDelete(
                "18yVqkdbdRvS24c0Ilj2ci","1HGw3J3NxZO1TP1BTtVhpZ","7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myAudiobooksGetTest() {
        SpotifyRequestVariant request = new MyAudiobooksGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myAudiobooksPutTest() {
        SpotifyRequestVariant request = new MyAudiobooksPut(
                "18yVqkdbdRvS24c0Ilj2ci","1HGw3J3NxZO1TP1BTtVhpZ","7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myAudiobooksSavedGetTest() {
        SpotifyRequestVariant request = new MyAudiobooksSavedGet(
                "18yVqkdbdRvS24c0Ilj2ci","1HGw3J3NxZO1TP1BTtVhpZ","7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    
    /* *********** */
    /* ME/EPISODES */
    /* *********** */
    @Test
    @Tag("NetworkTest")
    public void myEpisodesDeleteTest() {
        SpotifyRequestVariant request = new MyEpisodesDelete(
                "7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myEpisodesGetTest() {
        SpotifyRequestVariant request = new MyEpisodesGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myEpisodesPutTest() {
        SpotifyRequestVariant request = new MyEpisodesPut(
                "7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myEpisodesSavedGetTest() {
        SpotifyRequestVariant request = new MyEpisodesSavedGet(
                "7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }
    
    
    /* ********* */
    /* ME/PLAYER */
    /* ********* */
    @Test
    @Tag("NetworkTest")
    public void myPlayerCurrentlyPlayingGetTest() {
        SpotifyRequestVariant request = new MyPlayerCurrentlyPlayingGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerDevicesGetTest() {
        SpotifyRequestVariant request = new MyPlayerDevicesGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerGetTest() {
        SpotifyRequestVariant request = new MyPlayerGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

//    @Test
//    @Tag("NetworkTest")
//    public void myPlayerNextPostTest() {
//        SpotifyRequestVariant request = new MyPlayerNextPost();
//        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
//        assertTrue(spotifyResponse.wasSuccess());
//    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerPausePutTest() {
        SpotifyRequestVariant request = new MyPlayerPausePut();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

//    @Test
//    @Tag("NetworkTest")
//    public void myPlayerPreviousPostTest() {
//        SpotifyRequestVariant request = new MyPlayerPreviousPost();
//        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
//        assertTrue(spotifyResponse.wasSuccess());
//    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerQueueGetTest() {
        SpotifyRequestVariant request = new MyPlayerQueueGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

//    @Test
//    @Tag("NetworkTest")
//    public void myPlayerQueuePostTest() {
//        SpotifyRequestVariant request = new MyPlayerQueuePost();
//        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
//        assertTrue(spotifyResponse.wasSuccess());
//    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerRecentlyPlayedGetTest() {
        SpotifyRequestVariant request = new MyPlayerRecentlyPlayedGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerRepeatPutTest() {
        SpotifyRequestVariant request = new MyPlayerRepeatPut("off");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerResumePutTest() {
        SpotifyRequestVariant request = new MyPlayerResumePut();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerSeekPutTest() {
        SpotifyRequestVariant request = new MyPlayerSeekPut(0);
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerSetVolumePutTest() {
        SpotifyRequestVariant request = new MyPlayerSetVolumePut(100);
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerToggleShufflePutTest() {
        SpotifyRequestVariant request = new MyPlayerToggleShufflePut(false);
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myPlayerTransferPutTest() {
        SpotifyRequestVariant request = new MyPlayerTransferPut("1316a1f83687f83a5a875c417cf5cdb6ec39840c");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


    /* ************ */
    /* ME/PLAYLISTS */
    /* ************ */
    @Test
    @Tag("NetworkTest")
    public void myPlaylistsGetTest() {
        SpotifyRequestVariant request = new MyPlaylistsGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }
    
    
    /* ******** */
    /* ME/SHOWS */
    /* ******** */
    @Test
    @Tag("NetworkTest")
    public void myShowsDeleteTest() {
        SpotifyRequestVariant request = new MyShowsDelete("5CfCWKI5pZ28U0uOzXkDHe","5as3aKmN2k11yfDDDSrvaZ");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myShowsGetTest() {
        SpotifyRequestVariant request = new MyShowsGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myShowsPutTest() {
        SpotifyRequestVariant request = new MyShowsPut("5CfCWKI5pZ28U0uOzXkDHe","5as3aKmN2k11yfDDDSrvaZ");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myShowsSavedGetTest() {
        SpotifyRequestVariant request = new MyShowsSavedGet("5CfCWKI5pZ28U0uOzXkDHe","5as3aKmN2k11yfDDDSrvaZ");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }
    
    
    /* ********* */
    /* ME/TRACKS */
    /* ********* */
    @Test
    @Tag("NetworkTest")
    public void myTracksDeleteTest() {
        SpotifyRequestVariant request = new MyTracksDelete(
                "7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myTracksGetTest() {
        SpotifyRequestVariant request = new MyTracksGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myTracksPutTest() {
        SpotifyRequestVariant request = new MyTracksPut(
                "7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void myTracksSavedGetTest() {
        SpotifyRequestVariant request = new MyTracksSavedGet(
                "7ouMYWpwJ422jRcDASZB7P","4VqPOruhp5EdPBeR92t6lQ","2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }
}
