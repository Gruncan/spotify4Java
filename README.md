<img align="right" src="https://storage.googleapis.com/pr-newsroom-wp/1/2018/11/Spotify_Logo_CMYK_Green.png" width="25%">

# Spotify for Java (Still under development)

Spotify api wrapper for java. <a href="https://gruncan.github.io/spotify4Java/"> JavaDocs</a>

Written for enjoyment and a way to learn java concepts that I have rarely/never used.
Demonstrated usage of OAuth 2.0 and java reflections, generics, networking, and concurrency.

## How it do

Firstly create an app at spotify's dashboard https://developer.spotify.com/dashboard/applications

Example:

```java
SpotifyClient spotifyClient = new SpotifyClientBuilder("CLIENT_ID", "CLIENT_SECRET", "REDIRECT_URL")
                                                        .getBuiltClient();
```

- ``CLIENT_ID`` is found at your newly create app's dashboard
- ``CLIENT_SECRET`` is again found at your app's dashboard
- ``REDRIECT_URL`` has to be set in your app's dashboard

``getBuiltClient()`` will make/create the necessary requests/server following spotify's OAuth 2.0 authentication
framework

<img src="https://developer.spotify.com/images/documentation/web-api/auth-code-flow.png" width="70%">

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
public static void main(String[] args){
    SpotifyClient spotifyClient = new SpotifyClientBuilder("CLIENT_ID", "CLIENT_SECRET", "REDIRECT_URL").getBuiltClient();
    TrackGet trackGet = new TrackGet("Track_id");
    SpotifyResponse response = spotifyClient.executeRequest(trackGet);
    JSONObject jsonObject = response.getJsonObject();
    System.out.println(jsonObject.toString());
}
```

Returns a `SpotifyResponse` that encapsulates the json response from the spotify api

All Json classes were taken from https://github.com/tdunning/open-json with only minor edits.

### <u>Requests modelled by this api so far</u>

<details open>
<summary><strong><u>Album:</u></strong></summary>

- AlbumGet ([api.spotify.com/v1/albums/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album))
- AlbumTracksGet ([api.spotify.com/v1/albums/{id}/tracks](https://developer.spoify.com/documentation/web-api/reference/#/operations/get-an-albums-tracks))
- SeveralAlbumsGet ([api.spotify.com/v1/albums](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-albums))

</details>
<br>
<details open>
<summary><strong><u>Artists:</u></strong></summary>

- ArtistGet ([api.spotify.com/v1/artists/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artist))
- ArtistsAlbumsGet ([api.spotify.com/v1/artists/{id}/albums](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-albums))
- ArtistsRelatedArtistsGet ([api.spotify.com/v1/artists/related-artists](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-related-artists))
- ArtistTopTracksGet ([api.spotify.com/v1/artists/{id}/top-tracks](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-top-tracks))
- SeveralArtistsGet ([api.spotify.com/v1/artists](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-artists))

</details>
<br>
<details open>
<summary><strong><u>Audiobooks:</u></strong></summary>

- AudiobookGet ([api.spotify.com/v1/audiobooks/{id}](https://developer.spotify.com/documentation/web-api/reference/get-an-audiobook))
- SeveralAudioBooksGet ([api.spotify.com/v1/audiobooks/](https://developer.spotify.com/documentation/web-api/reference/get-multiple-audiobooks))
- AudiobookChaptersGet ([api.spotify.com/v1/audiobooks/{id}/chapters](https://developer.spotify.com/documentation/web-api/reference/get-audiobook-chapters))

</details>
<br>
<details open>
<summary><strong><u>Categories:</u></strong></summary>

- CategoriesGet ([api.spotify.com/v1/browse/categories/{category_id}](https://developer.spotify.com/documentation/web-api/reference/get-a-category))
- SeveralCategoriesGet ([api.spotify.com/v1/browse/categories](https://developer.spotify.com/documentation/web-api/reference/get-categories))

</details>
<br>
<details open>
<summary><strong><u>Chapters:</u></strong></summary>

- ChapterGet ([api.spotify.com/v1/chapters/{id}](https://developer.spotify.com/documentation/web-api/reference/get-a-chapter))
- SeveralChaptersGet ([api.spotify.com/v1/chapters](https://developer.spotify.com/documentation/web-api/reference/get-several-chapters))

</details>
<br>
<details open>
<summary><strong><u>Episodes:</u></strong></summary>

- EpisodeGet ([api.spotify.com/v1/episodes/{id}](https://developer.spotify.com/documentation/web-api/reference/get-an-episode))
- SeveralEpisodesGet ([api.spotify.com/v1/episodes](https://developer.spotify.com/documentation/web-api/reference/get-multiple-episodes))

</details>
<br>
<details open>
<summary><strong><u>Genres:</u></strong></summary>

- GenreAvailableGet ([api.spotify.com/v1/recommendations/available-genre-seeds](https://developer.spotify.com/documentation/web-api/reference/get-recommendation-genres))

</details>
<br>
<details open>
<summary><strong><u>Markets:</u></strong></summary>

- MarketsAvailableGet ([api.spotify.com/v1/markets](https://developer.spotify.com/documentation/web-api/reference/get-available-markets))

</details>
<br>
<details open>
<summary><strong><u>Playlists:</u></strong></summary>

- PlaylistGet ([api.spotify.com/v1/playlists/{playlist_id}](https://developer.spotify.com/documentation/web-api/reference/get-playlist))
- CategoriesPlaylistsGet ([api.spotify.com/v1/browse/categories/{category_id}/playlists](https://developer.spotify.com/documentation/web-api/reference/get-a-categories-playlists))
- FeaturedPlaylistGet ([api.spotify.com/v1/browse/featured-playlists](https://developer.spotify.com/documentation/web-api/reference/get-featured-playlists))
- PlaylistImageGet ([api.spotify.com/v1/playlists/{playlist_id}/images](https://developer.spotify.com/documentation/web-api/reference/get-playlist-cover))
- PlaylistTracksGet [api.spotify.com/v1/playlists/{playlist_id}/tracks](https://developer.spotify.com/documentation/web-api/reference/get-playlists-tracks))

</details>
<br>
<details open>
<summary><strong><u>Search:</u></strong></summary>

- SearchGet ([api.spotify.com/v1/search](https://developer.spotify.com/documentation/web-api/reference/search))

</details>
<br>
<details open>
<summary><strong><u>Shows:</u></strong></summary>

- ShowGet ([api.spotify.com/v1/shows/{id}](https://developer.spotify.com/documentation/web-api/reference/get-a-show))
- SeveralShowsGet ([api.spotify.com/v1/shows](https://developer.spotify.com/documentation/web-api/reference/get-multiple-shows))
- ShowEpisodesGet ([api.spotify.com/v1/shows/{id}/episodes](https://developer.spotify.com/documentation/web-api/reference/get-a-shows-episodes))


</details>
<br>
<details open>
<summary><strong><u>Tracks:</u></strong></summary>

- SeveralTrackAudioFeaturesGet ([api.spotify.com/audio-features](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-audio-features))
- SeveralTracksGet ([api.spotify.com/tracks](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks))
- TrackAudioAnalysisGet ([api.spotify.com/audio-analysis/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-analysis))
- TrackAudioFeaturesGet ([api.spotify.com/audio-features/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-features))
- TrackGet ([api.spotify.com/tracks/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-track))
- TrackRecommendationGet ([api.spotify.com/recommendations](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-recommendations))

</details>

### <u>Future Plans</u>
- Implement the remainder of api request
- Bring back Spring support for handling user authentication
- Add more branches of api requests not just web api
- Optimise multiple call different threads




