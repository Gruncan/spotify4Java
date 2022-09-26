<img align="right" src="https://storage.googleapis.com/pr-newsroom-wp/1/2018/11/Spotify_Logo_CMYK_Green.png" width="25%">

# Spotify for Java (Still under development)

Spotify api wrapper for java.

Written for enjoyment and a way to learn java concepts that I have rarely/never used.
Demonstrated usage of OAuth 2.0 and java reflections, generics, networking.

## How it do

Firstly create an app at spotify's dashboard https://developer.spotify.com/dashboard/applications

Example:

```java
SpotifyClient spotifyClient=new SpotifyClientBuilder("CLIENT_ID","CLIENT_SECRET","REDIRECT_URL")
        .getBuiltClient();
```

- ``CLIENT_ID`` is found at your newly create app's dashboard
- ``CLIENT_SECRET`` is again found at your app's dashboard
- ``REDRIECT_URL`` has to be set in your app's dashboard

``getBuiltClient()`` will make/create the necessary requests/server following spotify's OAuth 2.0 authentication
framework

<img src="https://developer.spotify.com/assets/AuthG_AuthoriztionCode.png" width="70%">

If however you already have an `access_token` you can use:

```java 
SpotifyClient spotifyClient = SpotifyClient.buildFromToken("access_token");
```

### Executing Requests

Executing a request is as simple as instantiating your chosen request class with selected constructor parameters for
said request
and executing it with your spotifyClient `executeRequest`

Example:

```java
public static void main(String[]args){
        SpotifyClient spotifyClient=new SpotifyClientBuilder("CLIENT_ID","CLIENT_SECRET","REDIRECT_URL")
        .getBuiltClient();
        TrackGet trackGet=new TrackGet("Track_id");
        JSONObject jsonObject=spotifyClient.executeRequest(trackGet);
        System.out.println(jsonObject.toString());
        }
```

Returns a `JSONObject` response that encapsulates the raw json response from the spotify api

All Json classes were taken from https://github.com/tdunning/open-json with only minor edits.

### <u>Requests modelled by this api so far</u>

<details open>
<summary><strong><u>Album:</u></strong></summary>

-
AlbumGet ([api.spotify.com/v1/albums/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album))
-
SeveralAlbumsGet ([api.spotify.com/v1/albums](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-albums))
-
AlbumTracksGet ([api.spotify.com/v1/albums/{id}/tracks](https://developer.spoify.com/documentation/web-api/reference/#/operations/get-an-albums-tracks))
-
AlbumsSavedMeGet ([api.spotify.com/v1/me/albums](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-saved-albums))
-
AlbumsCheckSavedGet ([api.spotify.com/v1/me/albums/contains](https://developer.spotify.com/documentation/web-api/reference/#/operations/check-users-saved-albums))

</details>
<br>
<details open>
<summary><strong><u>Artists:</u></strong></summary>

-
ArtistGet ([api.spotify.com/v1/artists/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artist))
-
SeveralArtistsGet ([api.spotify.com/v1/artists](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-artists))
-
ArtistsAlbumsGet ([api.spotify.com/v1/artists/{id}/albums](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-albums))
-
ArtistTopTracksGet ([api.spotify.com/v1/artists/{id}/top-tracks](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-top-tracks))
-
ArtistRelatedArtistsGet ([api.spotify.com/v1/artists/related-artists](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-related-artists))

</details>
<br>
<details>
<summary><strong><u>Shows</u></strong></summary>
</details>
<br>
<details>
<summary><strong><u>Episodes</u></strong></summary>
</details>
<br>
<details>
<summary><strong><u>Audiobooks</u></strong></summary>
</details>
<br>
<details>
<summary><strong><u>Chapters</u></strong></summary>
</details>
<br>
<details open>
<summary><strong><u>Tracks</u></strong></summary>

-
TrackGet ([api.spotify.com/tracks/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-track))
-
SeveralTracksGet ([api.spotify.com/tracks](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks))
-
TrackSavedMeGet ([api.spotify.com/me/tracks](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-saved-tracks))
-
TrackUserSavedGet ([api.spotify.com/me/tracks/contains](https://developer.spotify.com/documentation/web-api/reference/#/operations/check-users-saved-tracks))
-
SeveralTrackAudioFeaturesGet ([api.spotify.com/audio-features](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-audio-features))
-
TrackAudioFeaturesGet ([api.spotify.com/audio-features/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-features))
-
TrackAudioAnalysis ([api.spotify.com/audio-analysis/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-analysis))
-
TrackRecommendationGet ([api.spotify.com/recommendations](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-recommendations))

</details>
<br>
<details open>
<summary><strong><u>Search</u></strong></summary>

-
SearchGet ([api.spotify.com/search](https://developer.spotify.com/documentation/web-api/reference/#/operations/search))

</details>
<br>
<details open>
<summary><strong><u>User</u></strong></summary>

-
CurrentUserProfileGet ([api.spotify.com/me](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-current-users-profile))
-
UserTopItemsGet ([api.spotify.com/me/top/{type}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-top-artists-and-tracks))
-
UserProfileGet ([api.spotify.com/users/{user_id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-profile))
-
FollowedArtistsGet ([api.spotify.com/me/following](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-followed))
-
UserCheckFollowsArtistUserGet ([api.spotify.com/me/following/contains](https://developer.spotify.com/documentation/web-api/reference/#/operations/check-current-user-follows))
-
UserCheckFollowPlaylistGet ([api.spotify.com/playlists/{playlist_id}/followers/contains](https://developer.spotify.com/documentation/web-api/reference/#/operations/check-if-user-follows-playlist))

</details>
<br>
<details>
<summary><strong><u>Playlists</u></strong></summary>
</details>
<br>



<details>
<summary><strong><u>Categories</u></strong></summary>
</details>
<br>

<details>
<summary><strong><u>Genres</u></strong></summary>
</details>
<br>


<details>
<summary><strong><u>Player</u></strong></summary>
</details>
<br>


<details>
<summary><strong><u>Markets</u></strong></summary>
</details>
<br>

### <u>Future Plans</u>

- .
- .
- .




