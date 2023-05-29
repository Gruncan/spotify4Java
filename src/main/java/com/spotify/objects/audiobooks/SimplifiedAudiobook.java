package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.chapters.Chapter;
import com.spotify.objects.wrappers.Country;
import com.spotify.objects.wrappers.SpotifyCopyright;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedAudiobookObject
 *
 * @see Audiobook
 * @see Chapter
 * @see SpotifyObject
 */
@Getter
@Setter
public class SimplifiedAudiobook implements SpotifyObject {

    /**
     * The author(s) for the audiobook.
     */
    @SpotifyField
    private AudiobookAuthor[] authors;

    /**
     * A list of the countries in which the audiobook can be played, identified by their ISO 3166-1 alpha-2 code.
     */
    @SpotifyField("available_markets")
    private Country[] availableMarkets;

    /**
     * The copyright statements of the audiobook.
     */
    @SpotifyField
    private SpotifyCopyright[] copyrights;

    /**
     * A description of the audiobook. HTML tags are stripped away from this field, use html_description field in case HTML tags are needed.
     */
    @SpotifyField
    private String description;

    /**
     * A description of the audiobook. This field may contain HTML tags.
     */
    @SpotifyField("html_description")
    private String htmlDescription;

    /**
     * The edition of the audiobook.
     */
    @SpotifyField
    @SpotifyOptional
    private String edition;

    /**
     * Whether or not the audiobook has explicit content (true = yes it does; false = no it does not OR unknown).
     */
    @SpotifyField
    private boolean explicit;

    /**
     * External URLs for this audiobook.<br>
     * The Spotify URL for the object.
     */
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    /**
     * A link to the Web API endpoint providing full details of the audiobook.
     */
    @SpotifyField
    private String href;

    /**
     * The Spotify ID for the audiobook.
     */
    @SpotifyField
    private String id;

    /**
     * The cover art for the audiobook in various sizes, widest first.
     */
    @SpotifyField
    private SpotifyImage[] images;

    /**
     * A list of the languages used in the audiobook, identified by their ISO 639 code.
     */
    @SpotifyField
    private String[] languages;

    /**
     * The media type of the audiobook.
     */
    @SpotifyField("media_type")
    private String mediaType;

    /**
     * The name of the audiobook.
     */
    @SpotifyField
    private String name;

    /**
     * The narrator(s) for the audiobook.
     */
    @SpotifyField
    private AudiobookNarrator[] narrators;

    /**
     * The publisher of the audiobook.
     */
    @SpotifyField
    private String publisher;

    /**
     * The object type.
     */
    @SpotifyField
    private String type;

    /**
     * The Spotify URI for the audiobook.
     */
    @SpotifyField
    private String uri;

    /**
     * The number of chapters in this audiobook.
     */
    @SpotifyField("total_chapters")
    private int totalChapters;

}
