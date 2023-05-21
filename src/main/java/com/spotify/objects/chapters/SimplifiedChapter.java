package com.spotify.objects.chapters;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.audiobooks.AudiobookChapter;
import com.spotify.objects.wrappers.Country;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedChapterObject
 *
 * @see Chapter
 * @see AudiobookChapter
 * @see SpotifyObject
 */
@Getter
@Setter
public class SimplifiedChapter implements SpotifyObject {

    /**
     * A URL to a 30 second preview (MP3 format) of the episode. null if not available.
     */
    @SpotifyField("audio_preview_url")
    private String audioPreviewUrl;

    /**
     * A list of the countries in which the chapter can be played, identified by their ISO 3166-1 alpha-2 code.
     */
    @SpotifyOptional
    @SpotifyField("available_markets")
    private Country[] markets;

    /**
     * The number of the chapter
     */
    @SpotifyField("chapter_number")
    private int chapterNumber;

    /**
     * A description of the episode. HTML tags are stripped away from this field, use html_description field in case HTML tags are needed.
     */
    @SpotifyField
    private String description;

    /**
     * A description of the episode. This field may contain HTML tags.
     */
    @SpotifyField("html_description")
    private String htmlDescription;

    /**
     * The episode length in milliseconds.
     */
    @SpotifyField("duration_ms")
    private int duration;

    /**
     * Whether or not the episode has explicit content (true = yes it does; false = no it does not OR unknown).
     */
    @SpotifyField
    private boolean explicit;

    /**
     * External URLs for this episode.<br>
     * The Spotify URL for the object.
     */
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    /**
     * A link to the Web API endpoint providing full details of the episode.
     */
    @SpotifyField
    private String href;

    /**
     * The Spotify ID for the episode.
     */
    @SpotifyField
    private String id;

    /**
     * The cover art for the episode in various sizes, widest first.
     */
    @SpotifyField
    private SpotifyImage[] images;

    /**
     * True if the episode is playable in the given market. Otherwise false.
     */
    @SpotifyField("is_playable")
    private boolean isPlayable;

    /**
     * A list of the languages used in the episode, identified by their ISO 639-1 code.
     */
    @SpotifyField
    private String[] languages;

    /**
     * The name of the episode.
     */
    @SpotifyField
    private String name;

    /**
     * The date the episode was first released, for example "1981-12-15". Depending on the precision, it might be shown as "1981" or "1981-12".
     */
    @SpotifyField("release_date")
    private String releaseDate;

    /**
     * The precision with which release_date value is known.
     */
    @SpotifyField("release_date_precision")
    private String releaseDatePrecision;

    /**
     * The user's most recent position in the episode. Set if the supplied access token is a user token and has the scope 'user-read-playback-position'.
     */
    @SpotifyField("resume_point")
    private ChapterResumePoint resumePoint;

    /**
     * The object type.
     */
    @SpotifyField
    private String type;
    /**
     * The Spotify URI for the episode.
     */
    @SpotifyField
    private String uri;

    /**
     * Included in the response when a content restriction is applied.<br>
     * The reason for the restriction. Supported values:
     * <ul>
     *     <li>market - The content item is not available in the given market.</li>
     *     <li>product - The content item is not available for the user's subscription type.</li>
     *     <li>explicit - The content item is explicit and the user's account is set to not play explicit content.</li>
     *     <li>payment_required - Payment is required to play the content item.</li>
     * </ul>
     * Additional reasons may be added in the future. Note: If you use this field, make sure that your application safely handles unknown values.
     */
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restrictions;
}
