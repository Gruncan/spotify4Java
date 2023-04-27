package com.spotify.requests.util;

import com.spotify.SpotifyClient;
import com.spotify.SpotifyClientBuilder;
import com.spotify.requests.episodes.EpisodeGet;
import com.spotify.requests.episodes.SeveralEpisodesGet;
import com.spotify.requests.search.SearchGet;
import com.spotify.requests.shows.SeveralShowsGet;
import com.spotify.requests.shows.ShowEpisodesGet;
import com.spotify.requests.shows.ShowGet;

import java.util.List;


/**
 * The possible scope values of the authentication of the spotify app
 * @see SpotifyClientBuilder
 * @see SpotifyClient
 */
public enum Scope {


    /**
     * Write access to user-provided images.<br>
     * Upload images to Spotify on your behalf. <br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/upload-custom-playlist-cover">Add Custom Playlist Cover Image</a></li>
     * </ul>
     * @see ?
     */
    UGC_IMAGE_UPLOAD("ugc-image-upload"),

    /**
     * Read access to a user’s player state.<br>
     * Read your currently playing content and Spotify Connect devices information.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-a-users-available-devices">Get a User's Available Devices</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-information-about-the-users-current-playback">Get Information About The User's Current Playback</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-recently-played">Get the User's Currently Playing Track</a></li>
     * </ul>
     * @see ?
     * @see ?
     * @see ?
     */
    USER_READ_PLAYBACK_STATE("user-read-playback-state"),
    /**
     * Write access to a user’s playback state <br>
     * Control playback on your Spotify clients and Spotify Connect devices.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/pause-a-users-playback">Pause a User's Playback</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/seek-to-position-in-currently-playing-track">Seek To Position In Currently Playing Track</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/set-volume-for-users-playback">Set Repeat Mode On User’s Playback</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/skip-users-playback-to-next-track">Set Volume For User's Playback</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/skip-users-playback-to-previous-track">Skip User’s Playback To Previous Track</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/start-a-users-playback">Start/Resume a User's Playback</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/toggle-shuffle-for-users-playback">Toggle Shuffle For User’s Playback</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/transfer-a-users-playback">Transfer a User's Playback</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/seek-to-position-in-currently-playing-track">Add An Item To The End Of User's Current Playback Queue</a></li>
     * </ul>
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     */
    USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state"),

    /**
     * Read access to a user’s currently playing content.<br>
     * Read your currently playing content.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-recently-played">Get the User's Currently Playing Track</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-queue">Get the User's Queue</a></li>
     * </ul>
     * @see ?
     * @see ?
     */
    USER_READ_CURRENTLY_PLAYING("user-read-currently-playing"),

    /**
     * Remote control playback of Spotify. This scope is currently available to Spotify iOS and Android SDKs.<br>
     * Communicate with the Spotify app on your device.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/ios">iOS SDK</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/android">Android SDK</a></li>
     * </ul>
     * @see ?
     * @see ?
     */
    APP_REMOTE_CONTROL("app-remote-control"),

    /**
     * Control playback of a Spotify track. This scope is currently available to the Web Playback SDK.
     * The user must have a Spotify Premium account.<br>
     * Play content and control playback on your other devices.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-playback-sdk">Web Playback SDK</a></li>
     * </ul>
     * @see ?
     */
    STREAMING("streaming"),

    /**
     * Read access to user's private playlists.<br>
     * Access your private playlists.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/check-if-user-follows-playlist">Check if Users Follow a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-a-list-of-current-users-playlists">Get a List of Current User's Playlists</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-list-users-playlists">Get a List of a User's Playlists</a></li>
     * </ul>
     * @see ?
     * @see ?
     * @see ?
     */
    PLAYLIST_READ_PRIVATE("playlist-read-private"),

    /**
     * Include collaborative playlists when requesting a user's playlists.<br>
     * Access your collaborative playlists.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-a-list-of-current-users-playlists">Get a List of Current User's Playlists</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-list-users-playlists">Get a List of a User's Playlists</a></li>
     * </ul>
     * @see ?
     * @see ?
     */
    PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative"),

    /**
     * Write access to a user's private playlists.<br>
     * Manage your private playlists.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/follow-playlist">Follow a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/unfollow-playlist">Unfollow a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/add-tracks-to-playlist">Add Items to a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/change-playlist-details">Change a Playlist's Details</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/create-playlist">Create a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/remove-tracks-playlist">Remove Items from a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/reorder-or-replace-playlists-tracks">Reorder a Playlist's Items</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/reorder-or-replace-playlists-tracks">Replace a Playlist's Items</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/upload-custom-playlist-cover">Upload a Custom Playlist Cover Image</a></li>
     * </ul>
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     */
    PLAYLIST_MODIFY_PRIVATE("playlist-modify-private"),


    /**
     * Write/delete access to the list of artists and other users that the user follows.<br>
     * Manage who you are following.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/follow-playlist">Follow a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/unfollow-playlist">Unfollow a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/add-tracks-to-playlist">Add Items to a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/change-playlist-details">Change a Playlist's Details</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/create-playlist">Create a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/remove-tracks-playlist">Remove Items from a Playlist</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/reorder-or-replace-playlists-tracks">Reorder a Playlist's Items</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/reorder-or-replace-playlists-tracks">Replace a Playlist's Items</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/upload-custom-playlist-cover">Upload a Custom Playlist Cover Image</a></li>
     * </ul>
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     */
    PLAYLIST_MODIFY_PUBLIC("playlist-modify-public"),

    /**
     * Write/delete access to the list of artists and other users that the user follows.<br>
     * Manage who you are following.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/follow-artists-users">Follow Artists or Users</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/unfollow-artists-users">Unfollow Artists or Users</a></li>
     * </ul>
     * @see ?
     * @see ?
     */
    USER_FOLLOW_MODIFY("user-follow-modify"),

    /**
     * Read access to the list of artists and other users that the user follows.<br>
     * Access your followers and who you are following.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/check-current-user-follows">Check if Current User Follows Artists or Users</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-followed">Get User's Followed Artists</a></li>
     * </ul>
     * @see ?
     * @see ?
     */
    USER_FOLLOW_READ("user-follow-read"),

    /**
     * Read access to a user’s playback position in a content.<br>
     * Read your position in content you have played.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-an-episode">Get an Episodes</a> - {@link EpisodeGet}</li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-episodes">Get Several Episodes</a> - {@link SeveralEpisodesGet}</li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-a-show">Get a Show</a> - {@link ShowGet}</li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-showsd">Get Several Shows</a> - {@link SeveralShowsGet}</li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-a-shows-episodes">Get a Show's Episodes</a> - {@link ShowEpisodesGet}</li>
     * </ul>
     * @see EpisodeGet
     * @see SeveralEpisodesGet
     * @see ShowGet
     * @see SeveralShowsGet
     * @see ShowEpisodesGet
     */
    USER_READ_PLAYBACK_POSITION("user-read-playback-position"),

    /**
     * Read access to a user's top artists and tracks.<br>
     * Read your top artists and content.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-users-top-artists-and-tracks">Get a User's Top Artists and Tracks</a></li>
     * </ul>
     * @see ?
     */
    USER_TOP_READ("user-top-read"),

    /**
     * Read access to a user’s recently played tracks.<br>
     * Access your recently played items.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-the-users-currently-playing-track">Get Current User's Recently Played Tracks</a></li>
     * </ul>
     * @see ?
     */
    USER_READ_RECENTLY_PLAYED("user-read-recently-played"),

    /**
     * Write/delete access to a user's "Your Music" library.<br>
     * Manage your saved content.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/remove-albums-user">Remove Albums for Current User</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/remove-tracks-user">Remove User's Saved Tracks</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/remove-episodes-user">Remove User's Saved Episodes</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/save-albums-user">Save Albums for Current User</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/save-tracks-user">Save Tracks for User</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/save-episodes-user">Save Episodes for User</a></li>
     *
     * </ul>
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     */
    USER_LIBRARY_MODIFY("user-library-modify"),

    /**
     * Read access to a user's library.<br>
     * Access your saved content.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/check-users-saved-albums">Check User's Saved Albums</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/check-users-saved-tracks">Check User's Saved Tracks</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-users-saved-albums">Get Current User's Saved Albums</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-users-saved-tracks">Get a User's Saved Tracks</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/check-users-saved-episodes">Check User's Saved Episodes</a></li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-users-saved-episodes">Get User's Saved Episodes</a></li>
     * </ul>
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     * @see ?
     */
    USER_LIBRARY_READ("user-library-read"),

    /**
     * Read access to user’s email address.<br>
     * Get your real email address.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-current-users-profile">Get Current User's Profile</a></li>
     * </ul>
     * @see ?
     */
    USER_READ_EMAIL("user-read-email"),

    /**
     * Read access to user’s subscription details (type of user account).<br>
     * Access your subscription details.<br>
     * Required by:
     * <ul>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/search">Search for an Item</a> - {@link SearchGet}</li>
     *  <li><a href="https://developer.spotify.com/documentation/web-api/reference/get-current-users-profile">Get Current User's Profile</a></li>
     * </ul>
     * @see SearchGet
     * @see ?
     */
    USER_READ_PRIVATE("user-read-private");


    private final String scope;

    Scope(String scope) {
        this.scope = scope;
    }

    /**
     * Get the scope id
     * @return The scope's id/proper name
     */
    public String getScopeString() {
        return this.scope;
    }


    public static String[] convertToStringArray(List<Scope> scopes) {
        String[] strings = new String[scopes.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scopes.get(i).getScopeString();
        }
        return strings;
    }


}
