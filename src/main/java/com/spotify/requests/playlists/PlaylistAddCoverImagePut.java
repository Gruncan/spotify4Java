package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * Replace the image used to represent a specific playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/upload-custom-playlist-cover">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "playlists", end = "images",
        authorizations = {Scope.UGC_IMAGE_UPLOAD, Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.PUT)
public class PlaylistAddCoverImagePut implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Base64 encoded JPEG image data, maximum payload size is 256 KB.
     */
    @SpotifyRequestContent(isRaw = true, contentType = "image/jpeg")
    private final String image;

    /**
     * Initializes the {@link PlaylistAddCoverImagePut} request
     * @param id The Spotify ID of the playlist.
     * @param image The Base64 encoded image string
     */
    public PlaylistAddCoverImagePut(String id, String image) {
        this.id = id;
        this.image = image;
    }

    /**
     * Initializes the {@link PlaylistAddCoverImagePut} request
     * @param id The Spotify ID of the playlist.
     * @param file The file to be encoded
     */
    public PlaylistAddCoverImagePut(String id, File file) throws IOException {
        this(id, imageToBase64(file));
    }

    /**
     * A helper function to encode a image file in Base64 for request
     * @param file The file to encode
     * @return The Base64 encoded image as a {@link String} or {@code null} if the file is not of JPEG format
     * @throws IOException if an I/O error occurs reading from the stream
     */
    public static String imageToBase64(File file) throws IOException {
        if (file.getPath().endsWith(".jpeg")) return null;
        byte[] bytes = Files.readAllBytes(file.toPath());

        return Base64.getEncoder().encodeToString(bytes);

    }

}
