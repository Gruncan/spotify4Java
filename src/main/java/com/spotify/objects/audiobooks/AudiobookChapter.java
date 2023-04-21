package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.albums.SimplifiedAlbum;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Setter;

@Setter
public class AudiobookChapter extends AbstractSearchItems {


    private SimplifiedChapter[] items;

}
