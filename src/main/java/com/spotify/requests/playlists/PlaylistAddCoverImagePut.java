package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@SpotifyRequest(value = "playlists", end = "images",
        authorizations = {Scope.UGC_IMAGE_UPLOAD, Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.PUT)
public class PlaylistAddCoverImagePut implements SpotifyRequestVariant {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestContent(isRaw = true, contentType = "image/jpeg")
    private final String image;


    public PlaylistAddCoverImagePut(String id, String image) {
        this.id = id;
        this.image = image;
    }

    public PlaylistAddCoverImagePut(String id, File file) throws IOException {
        this(id, imageToBase64(file));
    }


    public static String imageToBase64(File file) throws IOException {
        byte[] bytes = Files.readAllBytes(file.toPath());

        return Base64.getEncoder().encodeToString(bytes);

    }

}
