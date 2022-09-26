package com.spotify.requests.users;

import com.spotify.json.JSONObject;
import com.spotify.objects.user.SpotifyUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CurrentUserProfileGetTest {

    @Test
    void serialize() {
        // the json to get back as an example response from execute.
        JSONObject response = new JSONObject("{\"country\":\"GB\",\"display_name\":\"Duncan Jones\",\"email\":\"dj223@outlook.com\",\"explicit_content\":{\"filter_enabled\":false,\"filter_locked\":false},\"external_urls\":{\"spotify\":\"https://open.spotify.com/user/dj223-gb\"},\"followers\":{\"total\":6},\"href\":\"https://api.spotify.com/v1/users/dj223-gb\",\"id\":\"dj223-gb\",\"images\":[{\"url\":\"https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=215687718825007&height=300&width=300&ext=1658400961&hash=AeQuTLK8_J3FC0iEYeo\"}],\"product\":\"premium\",\"type\":\"user\",\"uri\":\"spotify:user:dj223-gb\"}");
        assertNotNull(response);
        CurrentUserProfileGet request = new CurrentUserProfileGet();
        SpotifyUser spotifyUser = request.serialize(response);

        assertNotNull(spotifyUser);


    }
}