package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.requests.me.audiobooks.MyAudiobooksGet;
import lombok.Getter;


/**
 * Represents spotify audiobook search results<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-saved-audiobooks">MyAudiobooksGet</a>
 *
 * @see MyAudiobooksGet
 * @see SimplifiedAudiobook
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class Audiobooks extends AbstractSearchItems implements SpotifyObject {


    /**
     * An array of {@link SimplifiedAudiobook} for an album
     */
    private SimplifiedAudiobook items;

}
