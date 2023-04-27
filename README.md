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
    SpotifyClient spotifyClient = new SpotifyClientBuilder("CLIENT_ID", "CLIENT_SECRET", "REDIRECT_URL")
                                                            .getBuiltClient();
    TrackGet trackGet = new TrackGet("Track_id");
    JSONObject jsonObject = spotifyClient.executeRequest(trackGet);
    System.out.println(jsonObject.toString());
}
```

Returns a `JSONObject` response that encapsulates the raw json response from the spotify api

All Json classes were taken from https://github.com/tdunning/open-json with only minor edits.

### <u>Requests modelled by this api so far</u>

<details open>
<summary><strong><u>Album:</u></strong></summary>

- **AlbumGet** ([api.spotify.com/v1/albums/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album))
- AlbumTracksGet ([api.spotify.com/v1/albums/{id}/tracks](https://developer.spoify.com/documentation/web-api/reference/#/operations/get-an-albums-tracks))
- **SeveralAlbumsGet** ([api.spotify.com/v1/albums](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-albums))

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
<summary><strong><u>Audiobooks</u></strong></summary>

- AudiobookGet
- SeveralAudioBooksGet

</details>
<br>
<details open>
<summary><strong><u>Chapters</u></strong></summary>

- ChapterGet
- SeveralChaptersGet

</details>
<br>
<details open>
<summary><strong><u>Categories</u></strong></summary>

- SeveralCategoriesGet
- SingleCategoriesGet

</details>
<br>
<details open>
<summary><strong><u>Episodes</u></strong></summary>

- EpisodeGet
- SeveralEpisodesGet

</details>
<br>
<details open>
<summary><strong><u>Genres</u></strong></summary>

- GenreAvailableGet

</details>
<br>
<details open>
<summary><strong><u>Markets</u></strong></summary>

- MarketsAvailableGet

</details>
<br>
<details open>
<summary><strong><u>Playlists</u></strong></summary>

- CategoriesPlaylistsGet
- FeaturedPlaylistGet
- PlaylistGet
- PlaylistImageGet
- PlaylistTracksGet

</details>
<br>
<details open>
<summary><strong><u>Search</u></strong></summary>

- **SearchGet**

</details>
<br>
<details open>
<summary><strong><u>Shows</u></strong></summary>

- SeveralShowsGet
- ShowEpisodesGet
- ShowGet

</details>
<br>
<details open>
<summary><strong><u>Tracks</u></strong></summary>

- **SeveralTrackAudioFeaturesGet** ([api.spotify.com/audio-features](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-audio-features))
- **SeveralTracksGet** ([api.spotify.com/tracks](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks))
- **TrackAudioAnalysisGet** ([api.spotify.com/audio-analysis/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-analysis))
- **TrackAudioFeaturesGet** ([api.spotify.com/audio-features/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-features))
- **TrackGet** ([api.spotify.com/tracks/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-track))
- **TrackRecommendationGet** ([api.spotify.com/recommendations](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-recommendations))

</details>

(<b>bold</b> items are able to be serialized into the respective classes)

### <u>Future Plans</u>
- Implement the remainder of api request
- Completely finish writing the spotify objects
- Rewrite how requests classes are written (annotations)
- Bring back Spring support for handling user authentication
- Add more branches of api requests not just web api
- Optimise multiple call different threads




