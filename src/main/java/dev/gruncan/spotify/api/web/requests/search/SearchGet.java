package dev.gruncan.spotify.api.web.requests.search;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.search.Search;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Type;
import lombok.Setter;

import java.util.stream.Stream;

/**
 * Get Spotify catalog information about albums, artists, playlists, tracks, shows, episodes or audiobooks that match a keyword string.
 * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/search">Spotify Docs</a>
 * <p>Serializes into {@link Search}</p>
 *
 * @see Search
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 * @see Type
 */
@Setter
@SpotifyRequest(value = "search")
@SpotifySerialize(Search.class)
public class SearchGet implements SpotifyRequestVariant {

    /**
     * Your search query.<br>
     * You can narrow down your search using field filters. The available filters are album, artist, track, year, upc, tag:hipster, tag:new, isrc, and genre. Each field filter only applies to certain result types.
     */
    @SpotifyRequestField
    private final String q;

    /**
     * A list of item {@link Type}s to search across. Search results include hits from all the specified item types.
     */
    @SpotifyRequestField
    private final Type[] type;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * The maximum number of results to return in each item type.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first result to return. Use with limit to get the next page of search results.
     */
    @SpotifyRequestField
    private int offset;

    /**
     * If include_external=audio is specified it signals that the client can play externally hosted audio content, and marks the content as playable in the response. By default externally hosted audio content is marked as unplayable in the response.
     */
    @SpotifyRequestField("include_external")
    private String includeExternal;


    public SearchGet(String q, String... type) {
        this(q, Stream.of(type).map(t -> {
            for (Type type1 : Type.values()) {
                if (t.equals(type1.toString())) {
                    return type1;
                }
            }
            return null;
        }).toArray(Type[]::new));
    }

    /**
     * Initializes the {@link SearchGet} request
     *
     * @param q    Your search query.
     * @param type A list of item {@link Type}s to search across.
     */
    public SearchGet(String q, Type... type) {
        this.q = q;
        this.type = type;
    }
}
