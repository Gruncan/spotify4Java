package com.spotify.requests.me.player;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/player", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerTransferPut implements SpotifyRequestVariant {

    @SpotifyRequestContent("device_ids")
    private final String[] ids;

    @SpotifyRequestContent
    private boolean canPlay;


    public MyPlayerTransferPut(String id) {
        this.ids = new String[]{id};
    }


}
