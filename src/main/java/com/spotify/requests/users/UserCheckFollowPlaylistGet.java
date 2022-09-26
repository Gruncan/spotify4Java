package com.spotify.requests.users;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.ParameterPair;
import com.spotify.util.Util;


/**
 * Check to see if one or more Spotify users are following a specified playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/check-if-user-follows-playlist">Spotify Docs</a>
 */
public class UserCheckFollowPlaylistGet extends AbstractRequest {

    private final static String URL = "playlist/{playlist_id}/followers/contains";

    private final String playlistId;


    /**
     * @param playlistID The id of the playlist to be queried
     * @param ids        The array of ids to check to see if they follow the playlist
     */
    public UserCheckFollowPlaylistGet(String playlistID, String... ids) {
        super(new ParameterPair("ids", String.class));
        super.addQuery(new RequestQuery<>("ids", Util.join(ids, ",")));
        this.playlistId = playlistID;
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL.replace("{playlist_id}", this.playlistId));
    }
}
