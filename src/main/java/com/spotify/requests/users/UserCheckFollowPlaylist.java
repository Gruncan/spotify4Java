package com.spotify.requests.users;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.ParameterPair;
import com.spotify.util.Util;


/**
 * Check to see if one or more Spotify users are following a specified playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/check-if-user-follows-playlist">Spotify Docs</a>
 */
public class UserCheckFollowPlaylist extends AbstractRequest {

    private final static String URL = "playlist/{playlist_id}/followers/contains";

    private final String playlist_id;


    /**
     * @param token       The token of the related spotify api session
     * @param playlist_id The id of the playlist to be queried
     * @param ids         The array of ids to check to see if they follow the playlist
     */
    public UserCheckFollowPlaylist(String token, String playlist_id, String... ids) {
        super(token, new ParameterPair("ids", String.class));
        super.addQuery(new RequestQuery<>("ids", Util.join(ids, ",")));
        this.playlist_id = playlist_id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{playlist_id}", this.playlist_id));
    }
}
