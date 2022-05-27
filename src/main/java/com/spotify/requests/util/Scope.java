package com.spotify.requests.util;

import com.spotify.requests.IRequest;
import com.spotify.requests.users.CurrentUserProfileGet;

import java.util.List;


/**
 * The possible scope values of the authentication of the spotify app
 */
public enum Scope {


    UGC_IMAGE_UPLOAD("ugc-image-upload"),
    USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state"),
    USER_FOLLOW_MODIFY("user-follow-modify"),
    USER_READ_RECENTLY_PLAYED("user-read-recently-played"),
    USER_READ_PLAYBACK_POSITION("user-read-playback-position"),
    PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative"),
    APP_REMOTE_CONTROL("app-remote-control"),
    USER_READ_PLAYBACK_STATE("user-read-playback-state"),
    USER_READ_EMAIL("user-read-email", CurrentUserProfileGet.class),
    STREAMING("streaming"),
    USER_TOP_READ("user-top-read"),
    PLAYLIST_MODIFY_PUBLIC("playlist-modify-public"),
    USER_LIBRARY_MODIFY("user-library-modify"),
    USER_FOLLOW_READ("user-follow-read"),
    USER_READ_CURRENTLY_PLAYING("user-read-currently-playing"),
    USER_LIBRARY_READ("user-library-read"),
    PLAYLIST_READ_PRIVATE("playlist-read-private"),
    USER_READ_PRIVATE("user-read-private"),
    PLAYLIST_MODIFY_PRIVATE("playlist-modify-private");


    private final String scope;
    private final Class<? extends IRequest>[] requestClasses;

    /**
     * @param scope The key query parameter of the related scope
     */
    Scope(String scope) {
        this.scope = scope;
        this.requestClasses = null;
    }

    /**
     * @param scope The key query parameter of the related scope
     * @param cls   The array of request classes that this scope gives access to
     */
    Scope(String scope, Class<? extends IRequest>... cls) {
        this.scope = scope;
        this.requestClasses = cls;
    }

    /**
     * Gets the key query parameter of the related scope
     *
     * @return {@code String} of the key query parameter
     */
    public String getScopeString() {
        return this.scope;
    }

    /**
     * Gets the classes that are related to the specific scope
     *
     * @return {@code Class<? extends IRequest>[]} an array of classes
     */
    public Class<? extends IRequest>[] getRequestClasses() {
        return this.requestClasses;
    }


    public static String[] convertToStringArray(List<Scope> scopes) {
        String[] strings = new String[scopes.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scopes.get(i).getScopeString();
        }
        return strings;
    }


}
