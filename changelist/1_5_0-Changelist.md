
# <u>Change list 1.5.0</u>
 - **com.spotify** renamed with proper domain name **dev.gruncan.spotify**
 - **spotify.objects** and **spotify.requests** moved deeper into **spotify.webapi.objects** and **spotify.webapi.requests**

### Request renames:


Renamed requests starting with "**Several**" to start with specific request name

| Previous Name |           |                      New Name |
|---------------|:---------:|------------------------------|
|SeveralAlbumsGet|  &#8594;  |               AlbumSeveralGet |
|ArtistTopTracksGet|  &#8594;  |           ArtistsTopTracksGet |
|SeveralArtistsGet|  &#8594;  |              ArtistSeveralGet |
|SeveralAudioBooksGet|  &#8594;  |           AudiobookSeveralGet |
|CategoriesGet|  &#8594;  |                   CategoryGet |
|SeveralCategoriesGet|  &#8594;  |            CategorySeveralGet |
|SeveralChaptersGet|  &#8594;  |             ChapterSeveralGet |
|SeveralEpisodesGet|  &#8594;  |             EpisodeSeveralGet |
|CategoriesPlaylistsGet|  &#8594;  |         PlaylistCategoriesGet |
|FeaturedPlaylistGet|  &#8594;  |           PlaylistFeaturedGet |
|SeveralShowsGet|  &#8594;  |                ShowSeveralGet |
|SeveralTracksGet|  &#8594;  |               TrackSeveralGet |
|SeveralTrackAudioFeaturesGet|  &#8594;  |   TrackAudioFeatureSeveralGet |




### Added support for remaining requests and serialization:

- AlbumReleasesGet
- MyAlbumsDelete
- MyAlbumsGet
- MyAlbumsPut
- MyAlbumsSavedGet
- MyAudiobooksDelete
- MyAudiobooksGet
- MyAudiobooksPut
- MyAudiobooksSavedGet
- MyEpisodesDelete
- MyEpisodesGet
- MyEpisodesPut
- MyEpisodesSavedGet
- MyFollowedArtistsGet
- MyFollowingPersonGet
- MyFollowPersonPut
- MyProfileGet
- MyTopInfo
- MyUnfollowPersonDelete
- MyPlayerCurrentlyPlayingGet
- MyPlayerDevicesGet
- MyPlayerGet
- MyPlayerNextPost
- MyPlayerPausePut
- MyPlayerPreviousPost
- MyPlayerQueueGet
- MyPlayerQueuePost
- MyPlayerRecentlyPlayedGet
- MyPlayerRepeatPut
- MyPlayerResumePut
- MyPlayerSeekPut
- MyPlayerSetVolumePut
- MyPlayerToggleShufflePut
- MyPlayerTransferPut
- MyPlaylistsGet
- MyShowsDelete
- MyShowsGet
- MyShowsPut
- MyShowsSavedGet
- MyTracksDelete
- MyTracksGet
- MyTracksPut
- MyTracksSavedGet
- PlaylistAddCoverImagePut
- PlaylistAddItemPost
- PlaylistChangeDetailsPut
- PlaylistFollowingCheckGet
- PlaylistFollowPut
- PlaylistRemoveItemDelete
- PlaylistUnfollowDelete
- PlaylistUpdatePut