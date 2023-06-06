package com.spotify.objects.user;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.wrappers.SpotifyExplicitContent;
import com.spotify.requests.me.MyProfileGet;
import lombok.Getter;


/**
 * Represents the current users profile.
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-profile">UserProfileGet</a>
 *
 * @see MyProfileGet
 * @see SpotifyExplicitContent
 * @see SimplifiedUser
 * @see SpotifyObject
 */

@Getter
@SpotifyOptional
public class Profile extends SimplifiedUser implements SpotifyObject {

    /**
     * The country of the user, as set in the user's account profile. An ISO 3166-1 alpha-2 country code.
     * This field is only available when the current user has granted access to the user-read-private scope.
     */
    @SpotifyField
    private String country;

    /**
     * The user's email address, as entered by the user when creating their account.
     * Important! This email address is unverified; there is no proof that it actually belongs to the user.
     * This field is only available when the current user has granted access to the user-read-email scope.
     */
    @SpotifyField
    private String email;

    /**
     * The user's explicit content settings. This field is only available when the current user has granted access to the user-read-private scope.
     */
    @SpotifyField("explicit_content")
    private SpotifyExplicitContent explicitContent;

    /**
     * The user's Spotify subscription level: "premium", "free", etc. (The subscription level "open" can be considered the same as "free".)
     * This field is only available when the current user has granted access to the user-read-private scope.
     */
    @SpotifyField
    private String product;



}
