<img align="right" src="https://storage.googleapis.com/pr-newsroom-wp/1/2018/11/Spotify_Logo_CMYK_Green.png" width="25%">

# Spotify for Java (Still under development)

Spotify api wrapper for java. <a href="https://s4j.gruncan.dev/"> JavaDocs</a>

Written for enjoyment and a way to learn java concepts that I have rarely/never used.
Demonstrated usage of OAuth 2.0 and java reflections, generics, networking, and concurrency.

## Maven

```XML
<dependency>
    <groupId>dev.gruncan.s4j</groupId>
    <artifactId>S4J</artifactId>
    <version>1.5.0</version>
</dependency>
```
## Version Roadmap
- **v1.0.0: WebAPI**
- v2.0.0: AdAPI
- v3.0.0: Embeds
- v4.0.0: Open Access

_Most often all rquests will be implemented before x.5.0 and all serialization before next major version_

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
- AlbumSeveralGet ([api.spotify.com/v1/albums](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-albums))
- AlbumReleasesGet ([api.spotify.com/v1/browse/new-releases](https://developer.spotify.com/documentation/web-api/reference/get-new-releases))

</details>
<br>
<details open>
<summary><strong><u>Artists:</u></strong></summary>

- ArtistGet ([api.spotify.com/v1/artists/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artist))
- ArtistsAlbumsGet ([api.spotify.com/v1/artists/{id}/albums](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-albums))
- ArtistsRelatedArtistsGet ([api.spotify.com/v1/artists/related-artists](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-related-artists))
- ArtistsTopTracksGet ([api.spotify.com/v1/artists/{id}/top-tracks](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-top-tracks))
- ArtistSeveralGet ([api.spotify.com/v1/artists](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-artists))

</details>
<br>
<details open>
<summary><strong><u>Audiobooks:</u></strong></summary>

- AudiobookGet ([api.spotify.com/v1/audiobooks/{id}](https://developer.spotify.com/documentation/web-api/reference/get-an-audiobook))
- AudiobookSeveralGet ([api.spotify.com/v1/audiobooks/](https://developer.spotify.com/documentation/web-api/reference/get-multiple-audiobooks))
- AudiobookChaptersGet ([api.spotify.com/v1/audiobooks/{id}/chapters](https://developer.spotify.com/documentation/web-api/reference/get-audiobook-chapters))

</details>
<br>
<details open>
<summary><strong><u>Categories:</u></strong></summary>

- CategoryGet ([api.spotify.com/v1/browse/categories/{category_id}](https://developer.spotify.com/documentation/web-api/reference/get-a-category))
- CategorySeveralGet ([api.spotify.com/v1/browse/categories](https://developer.spotify.com/documentation/web-api/reference/get-categories))

</details>
<br>
<details open>
<summary><strong><u>Chapters:</u></strong></summary>

- ChapterGet ([api.spotify.com/v1/chapters/{id}](https://developer.spotify.com/documentation/web-api/reference/get-a-chapter))
- ChapterSeveralGet ([api.spotify.com/v1/chapters](https://developer.spotify.com/documentation/web-api/reference/get-several-chapters))

</details>
<br>
<details open>
<summary><strong><u>Episodes:</u></strong></summary>

- EpisodeGet ([api.spotify.com/v1/episodes/{id}](https://developer.spotify.com/documentation/web-api/reference/get-an-episode))
- EpisodeSeveralGet ([api.spotify.com/v1/episodes](https://developer.spotify.com/documentation/web-api/reference/get-multiple-episodes))

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
<summary><strong><u>Me:</u></strong></summary>

- MyAlbumsDelete ([api.spotify.com/v1/me/albums](https://developer.spotify.com/documentation/web-api/reference/remove-albums-user))
- MyAlbumsGet ([api.spotify.com/v1/me/albums](https://developer.spotify.com/documentation/web-api/reference/get-users-saved-albums))
- MyAlbumsPut ([api.spotify.com/v1/me/albums](https://developer.spotify.com/documentation/web-api/reference/save-albums-user))
- MyAlbumsSavedGet ([api.spotify.com/v1/me/albums](https://developer.spotify.com/documentation/web-api/reference/check-users-saved-albums))


- MyAudiobooksDelete ([api.spotify.com/v1/me/audiobooks](https://developer.spotify.com/documentation/web-api/reference/remove-audiobooks-user))
- MyAudiobooksGet ([api.spotify.com/v1/me/audiobooks](https://developer.spotify.com/documentation/web-api/reference/get-users-saved-audiobooks))
- MyAudiobooksPut ([api.spotify.com/v1/me/audiobooks](https://developer.spotify.com/documentation/web-api/reference/save-audiobooks-user))
- MyAudiobooksSavedGet ([api.spotify.com/v1/me/audiobooks](https://developer.spotify.com/documentation/web-api/reference/check-users-saved-audiobooks))


- MyEpisodesDelete ([api.spotify.com/v1/me/episodes](https://developer.spotify.com/documentation/web-api/reference/remove-episodes-user))
- MyEpisodesGet ([api.spotify.com/v1/me/episodes](https://developer.spotify.com/documentation/web-api/reference/check-users-saved-episodes))
- MyEpisodesPut ([api.spotify.com/v1/me/episodes](https://developer.spotify.com/documentation/web-api/reference/save-episodes-user))
- MyEpisodesSavedGet ([api.spotify.com/v1/me/episodes](https://developer.spotify.com/documentation/web-api/reference/check-users-saved-episodes))


- MyFollowedArtistsGet ([api.spotify.com/v1/me/following](https://developer.spotify.com/documentation/web-api/reference/get-followed))
- MyFollowingPersonGet ([api.spotify.com/v1/me/following/contains](https://developer.spotify.com/documentation/web-api/reference/check-current-user-follows))
- MyFollowPersonPut ([api.spotify.com/v1/me/following](https://developer.spotify.com/documentation/web-api/reference/follow-artists-users))
- MyProfileGet ([api.spotify.com/v1/me](https://developer.spotify.com/documentation/web-api/reference/get-current-users-profile))
- MyTopInfo ([api.spotify.com/v1/me/top/{type}](https://developer.spotify.com/documentation/web-api/reference/get-users-top-artists-and-tracks))
- MyUnfollowPersonDelete ([api.spotify.com/v1/me/following](https://developer.spotify.com/documentation/web-api/reference/unfollow-artists-users))
- MyPlayerCurrentlyPlayingGet ([api.spotify.com/v1/me/player/currently-playing](https://developer.spotify.com/documentation/web-api/reference/get-the-users-currently-playing-track))
- MyPlayerDevicesGet ([api.spotify.com/v1/me/player/devices](https://developer.spotify.com/documentation/web-api/reference/get-a-users-available-devices))
- MyPlayerGet ([api.spotify.com/v1/me/player](https://developer.spotify.com/documentation/web-api/reference/get-information-about-the-users-current-playback))
- ~~MyPlayerNextPost~~
- MyPlayerPausePut ([api.spotify.com/v1/me/player/pause](https://developer.spotify.com/documentation/web-api/reference/pause-a-users-playback))
- ~~MyPlayerPreviousPost~~
- MyPlayerQueueGet ([api.spotify.com/v1/me/player/queue](https://developer.spotify.com/documentation/web-api/reference/get-queue))
- ~~MyPlayerQueuePost~~
- MyPlayerRecentlyPlayedGet ([api.spotify.com/v1/me/player/recently-played](https://developer.spotify.com/documentation/web-api/reference/get-recently-played))
- MyPlayerRepeatPut ([api.spotify.com/v1/me/player/repeat](https://developer.spotify.com/documentation/web-api/reference/set-repeat-mode-on-users-playback))
- MyPlayerResumePut ([api.spotify.com/v1/me/player/play](https://developer.spotify.com/documentation/web-api/reference/start-a-users-playback))
- MyPlayerSeekPut ([api.spotify.com/v1/me/player/seek](https://developer.spotify.com/documentation/web-api/reference/seek-to-position-in-currently-playing-track))
- MyPlayerSetVolumePut ([api.spotify.com/v1/me/player/volume](https://developer.spotify.com/documentation/web-api/reference/set-volume-for-users-playback))
- MyPlayerToggleShufflePut ([api.spotify.com/v1/me/player/shuffle](https://developer.spotify.com/documentation/web-api/reference/toggle-shuffle-for-users-playback))
- MyPlayerTransferPut ([api.spotify.com/v1/me/player](https://developer.spotify.com/documentation/web-api/reference/transfer-a-users-playback))
- MyPlaylistsGet ([api.spotify.com/v1/me/playlists](https://developer.spotify.com/documentation/web-api/reference/get-a-list-of-current-users-playlists))
 

- MyShowsDelete ([api.spotify.com/v1/me/shows](https://developer.spotify.com/documentation/web-api/reference/remove-shows-user))
- MyShowsGet ([api.spotify.com/v1/me/shows](https://developer.spotify.com/documentation/web-api/reference/get-users-saved-shows))
- MyShowsPut ([api.spotify.com/v1/me/shows](https://developer.spotify.com/documentation/web-api/reference/save-shows-user))
- MyShowsSavedGet ([api.spotify.com/v1/me/shows](https://developer.spotify.com/documentation/web-api/reference/check-users-saved-shows))


- MyTracksDelete ([api.spotify.com/v1/me/tracks](https://developer.spotify.com/documentation/web-api/reference/remove-tracks-user))
- MyTracksGet ([api.spotify.com/v1/me/tracks](https://developer.spotify.com/documentation/web-api/reference/get-users-saved-tracks))
- MyTracksPut ([api.spotify.com/v1/me/tracks](https://developer.spotify.com/documentation/web-api/reference/save-tracks-user))
- MyTracksSavedGet ([api.spotify.com/v1/me/tracks](https://developer.spotify.com/documentation/web-api/reference/save-tracks-user))

<details open>
<summary><strong><u>Playlists:</u></strong></summary>

- PlaylistGet ([api.spotify.com/v1/playlists/{playlist_id}](https://developer.spotify.com/documentation/web-api/reference/get-playlist))
- PlaylistCategoriesGet ([api.spotify.com/v1/browse/categories/{category_id}/playlists](https://developer.spotify.com/documentation/web-api/reference/get-a-categories-playlists))
- PlaylistFeaturedGet ([api.spotify.com/v1/browse/featured-playlists](https://developer.spotify.com/documentation/web-api/reference/get-featured-playlists))
- PlaylistImageGet ([api.spotify.com/v1/playlists/{playlist_id}/images](https://developer.spotify.com/documentation/web-api/reference/get-playlist-cover))
- PlaylistTracksGet [api.spotify.com/v1/playlists/{playlist_id}/tracks](https://developer.spotify.com/documentation/web-api/reference/get-playlists-tracks))
- PlaylistAddCoverImagePut ([/api.spotify.com/v1/playlists/{playlist_id}/images](https://developer.spotify.com/documentation/web-api/reference/upload-custom-playlist-cover))
- PlaylistAddItemPost ([api.spotify.com/v1/playlists/{playlist_id}/tracks](https://developer.spotify.com/documentation/web-api/reference/add-tracks-to-playlist))
- PlaylistChangeDetailsPut ([api.spotify.com/v1/playlists/{playlist_id}](https://developer.spotify.com/documentation/web-api/reference/change-playlist-details))
- PlaylistFollowingCheckGet ([api.spotify.com/v1/playlists/{playlist_id}/followers/contains](https://developer.spotify.com/documentation/web-api/reference/check-if-user-follows-playlist))
- PlaylistFollowPut ([api.spotify.com/v1/playlists/{playlist_id}/followers](https://developer.spotify.com/documentation/web-api/reference/follow-playlist))
- PlaylistRemoveItemDelete ([api.spotify.com/v1/playlists/{playlist_id}/tracks](https://developer.spotify.com/documentation/web-api/reference/remove-tracks-playlist))
- PlaylistUnfollowDelete ([api.spotify.com/v1/playlists/{playlist_id}/followers](https://developer.spotify.com/documentation/web-api/reference/unfollow-playlist))
- PlaylistUpdatePut ([api.spotify.com/v1/playlists/{playlist_id}/tracks](https://developer.spotify.com/documentation/web-api/reference/reorder-or-replace-playlists-tracks))

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
- ShowSeveralGet ([api.spotify.com/v1/shows](https://developer.spotify.com/documentation/web-api/reference/get-multiple-shows))
- ShowEpisodesGet ([api.spotify.com/v1/shows/{id}/episodes](https://developer.spotify.com/documentation/web-api/reference/get-a-shows-episodes))


</details>
<br>
<details open>
<summary><strong><u>Tracks:</u></strong></summary>

- TrackAudioFeatureSeveralGet ([api.spotify.com/audio-features](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-audio-features))
- TrackSeveralGet ([api.spotify.com/tracks](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks))
- TrackAudioAnalysisGet ([api.spotify.com/audio-analysis/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-analysis))
- TrackAudioFeaturesGet ([api.spotify.com/audio-features/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-features))
- TrackGet ([api.spotify.com/tracks/{id}](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-track))
- TrackRecommendationGet ([api.spotify.com/recommendations](https://developer.spotify.com/documentation/web-api/reference/#/operations/get-recommendations))

</details>
<br>
<details open>
<summary><strong><u>User:</u></strong></summary>

- UserPlaylistCreatePost ([api.spotify.com/v1/users/{user_id}/playlists](https://developer.spotify.com/documentation/web-api/reference/create-playlist))
- UserPlaylistGet ([api.spotify.com/v1/users/{user_id}/playlists](https://developer.spotify.com/documentation/web-api/reference/get-list-users-playlists))
- UserProfileGet ([api.spotify.com/v1/users/{user_id}](https://developer.spotify.com/documentation/web-api/reference/get-users-profile))
</details>

Scored through requests are implemented but API endpoints do not work on spotify's end. 

### <u>Future Plans</u>
- Bring back Spring support for handling user authentication
- Add more branches of api requests not just web api
- Optimise multiple call different threads




