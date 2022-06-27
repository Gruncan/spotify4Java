package com.spotify.objects;

import com.spotify.json.JSONArray;
import com.spotify.json.JSONException;
import com.spotify.json.JSONObject;
import com.spotify.objects.search.SearchResult;
import com.spotify.objects.track.*;
import com.spotify.objects.user.SpotifyUser;
import com.spotify.requests.util.Market;

import java.util.ArrayList;
import java.util.List;

public class SerializeObject {


    public SpotifyUser serializeSpotifyUser(JSONObject json) {
        JSONObject explicitContent = json.getJSONObject("explicit_content");
        boolean[] expContentArr = new boolean[]{explicitContent.getBoolean("filter_enabled"), explicitContent.getBoolean("filter_locked")};

        JSONObject externalUrls = json.getJSONObject("external_urls");

        String externalUrlsSpotify = externalUrls.getString("spotify");

        JSONObject followersObject = json.getJSONObject("followers");
        int followers = followersObject.getInt("total");

        JSONArray images = json.getJSONArray("images");

        SpotifyImage[] spotifyImages = new SpotifyImage[images.length()];
        for (int i = 0; i < images.length(); i++) {
            JSONObject jsonObject = (JSONObject) images.get(i);
            spotifyImages[i] = new SpotifyImage(jsonObject.getString("url") /*, jsonObject.getInt("height"), jsonObject.getInt("width")*/);
        }

        return new SpotifyUser(json.getString("country"), json.getString("display_name"), json.getString("email"), externalUrlsSpotify, followers,
                json.getString("href"), json.getString("id"), spotifyImages, json.getString("product"),
                json.getString("uri"));
    }

    public TrackAudioAnalysis serializeTrackAudioAnalysis(JSONObject json) {
        TrackAudioAnalysis.Meta meta = this.serializeTrackAudioMeta(json.getJSONObject("meta"));
        TrackAudioAnalysis.Track track = this.serializeTrackAudioTrack(json.getJSONObject("track"));

        JSONArray jsonBars = json.getJSONArray("bars");
        TrackAudioAnalysis.Bar[] bars = new TrackAudioAnalysis.Bar[jsonBars.length()];
        for (int i = 0; i < bars.length; i++) {
            bars[i] = this.serializeTrackAudioBar(jsonBars.getJSONObject(i));
        }

        JSONArray jsonBeats = json.getJSONArray("beats");
        TrackAudioAnalysis.Beat[] beats = new TrackAudioAnalysis.Beat[jsonBeats.length()];
        for (int i = 0; i < beats.length; i++) {
            beats[i] = this.serializeTrackAudioBeat(jsonBeats.getJSONObject(i));
        }

        JSONArray jsonSections = json.getJSONArray("sections");
        TrackAudioAnalysis.Section[] sections = new TrackAudioAnalysis.Section[jsonSections.length()];
        for (int i = 0; i < sections.length; i++) {
            sections[i] = this.serializeTrackAudioSection(jsonSections.getJSONObject(i));
        }


        JSONArray jsonSegments = json.getJSONArray("segments");
        TrackAudioAnalysis.Segment[] segments = new TrackAudioAnalysis.Segment[jsonSegments.length()];
        for (int i = 0; i < segments.length; i++) {
            segments[i] = this.serializeTrackAudioSegment(jsonSegments.getJSONObject(i));
        }


        JSONArray jsonTatums = json.getJSONArray("tatums");
        TrackAudioAnalysis.Tatum[] tatums = new TrackAudioAnalysis.Tatum[jsonTatums.length()];
        for (int i = 0; i < tatums.length; i++) {
            tatums[i] = this.serializeTrackAudioTatum(jsonTatums.getJSONObject(i));
        }


        return new TrackAudioAnalysis(meta, track, bars, beats, sections, segments, tatums);
    }

    private TrackAudioAnalysis.Meta serializeTrackAudioMeta(JSONObject json) {
        return new TrackAudioAnalysis.Meta(json.getString("analyzer_version"), json.getString("platform"), json.getString("detailed_status"),
                json.getInt("status_code"), json.getInt("timestamp"), (float) json.getDouble("analysis_time"),
                json.getString("input_process"));
    }

    private TrackAudioAnalysis.Track serializeTrackAudioTrack(JSONObject json) {
        return new TrackAudioAnalysis.Track(
                json.getInt("num_samples"), (float) json.getDouble("duration"),
                json.getString("sample_md5"), json.getInt("offset_seconds"), json.getInt("window_seconds"),
                json.getInt("analysis_sample_rate"), json.getInt("analysis_channels"),
                (float) json.getDouble("end_of_fade_in"), (float) json.getDouble("start_of_fade_out"),
                (float) json.getDouble("loudness"), (float) json.getDouble("tempo"),
                (float) json.getDouble("tempo_confidence"), json.getInt("time_signature"),
                (float) json.getDouble("time_signature_confidence"), json.getInt("key"),
                (float) json.getDouble("key_confidence"), json.getInt("mode"), (float) json.getDouble("key_confidence"),
                json.getString("codestring"), (float) json.getDouble("code_version"), json.getString("echoprintstring"),
                json.getInt("echoprint_version"), json.getString("synchstring"), json.getInt("synch_version"),
                json.getString("rhythmstring"), json.getInt("rhythm_version"));
    }

    private TrackAudioAnalysis.Bar serializeTrackAudioBar(JSONObject json) {
        return new TrackAudioAnalysis.Bar(((float) json.getDouble("start")),
                ((float) json.getDouble("duration")), ((float) json.getDouble("confidence")));
    }

    private TrackAudioAnalysis.Beat serializeTrackAudioBeat(JSONObject json) {
        return new TrackAudioAnalysis.Beat(((float) json.getDouble("start")),
                ((float) json.getDouble("duration")), ((float) json.getDouble("confidence")));
    }

    private TrackAudioAnalysis.Section serializeTrackAudioSection(JSONObject json) {
        return new TrackAudioAnalysis.Section((float) json.getDouble("start"), (float) json.getDouble("duration"),
                (float) json.getDouble("confidence"), (float) json.getDouble("loudness"),
                (float) json.getDouble("tempo"), (float) json.getDouble("tempo_confidence"), json.getInt("key"),
                (float) json.getDouble("key_confidence"), (float) json.getDouble("mode"),
                (float) json.getDouble("mode_confidence"), json.getInt("time_signature"),
                (float) json.getDouble("time_signature_confidence")
        );
    }

    private TrackAudioAnalysis.Segment serializeTrackAudioSegment(JSONObject json) {
        return new TrackAudioAnalysis.Segment((float) json.getDouble("start"), (float) json.getDouble("duration"),
                (float) json.getDouble("confidence"), (float) json.getDouble("loudness_start"),
                (float) json.getDouble("loudness_max"), (float) json.getDouble("loudness_max_time"),
                (float) json.getDouble("loudness_end"), this.fromJsonToFloatArray(json.getJSONArray("pitches")),
                this.fromJsonToFloatArray(json.getJSONArray("timbre")));
    }

    private TrackAudioAnalysis.Tatum serializeTrackAudioTatum(JSONObject json) {
        return new TrackAudioAnalysis.Tatum((float) json.getDouble("start"), (float) json.getDouble("duration"),
                (float) json.getDouble("confidence"));
    }

    public TrackAudioFeatures serializeTrackAudioFeatures(JSONObject json) {
        return new TrackAudioFeatures((float) json.getDouble("acousticness"), json.getString("analysis_url"),
                (float) json.getDouble("danceability"), json.getInt("duration_ms"), (float) json.getDouble("energy"),
                json.getString("id"), (float) json.getDouble("instrumentalness"), json.getInt("key"),
                (float) json.getDouble("liveness"), (float) json.getDouble("loudness"), json.getInt("mode"),
                (float) json.getDouble("speechiness"), (float) json.getDouble("tempo"), json.getInt("time_signature"),
                json.getString("track_href"), json.getString("type"), json.getString("uri"),
                (float) json.getDouble("valence")
        );
    }

    private static <T> T[] fromJsonToArray(JSONArray jsonArray) {
        if (jsonArray == null) return null;
        List<T> array = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            array.add((T) jsonArray.get(i));
        }
        return array.toArray((T[]) new Object[]{});
    }

    private TrackAlbum serializeTrackAlbum(JSONObject json) {
        return new TrackAlbum(json.getString("album_type"), json.getInt("total_tracks"),
                this.fromJsonToMarketArray(json.getJSONArray("available_markets")),
                json.getJSONObject("external_urls").getString("spotify"), json.getString("href"),
                json.getString("id"), this.fromJsonToImage(json.getJSONArray("images")),
                json.getString("name"), json.getString("release_date"), json.getString("release_date_precision"),
                this.getOptionalResponse(this.getJsonOptionalResponse(json, "restrictions"), "reason"), json.getString("type"),
                json.getString("uri"), this.getOptionalResponse(json, "album_group"),
                this.fromJsonToAlbumArtistArray(json.getJSONArray("artists"))
        );
    }

    private TrackArtist[] serializeTrackArtists(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == 0) return null;
        TrackArtist[] trackArtists = new TrackArtist[jsonArray.length()];
        for (int i = 0; i < trackArtists.length; i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            JSONObject followerObject = json.getJSONObject("followers");
            int total = followerObject != null ? followerObject.getInt("total") : -1;
            trackArtists[i] = new TrackArtist(this.getOptionalResponse(json.getJSONObject("external_url"), "spotify"),
                    followerObject == null ? -1 : followerObject.getInt("total"),
                    this.fromJsonToStringArray(json.getJSONArray("genres")), json.getString("href"),
                    json.getString("id"), this.fromJsonToImage(json.getJSONArray("images")),
                    json.getString("name"), json.has("popularity") ? json.getInt("popularity") : -1, json.getString("type"),
                    json.getString("uri"));
        }
        return trackArtists;
    }


    private SpotifyImage fromJsonToImage(JSONArray jsonArray) {
//        System.out.println(jsonArray== null ? null : jsonArray.toString(2));
        if (jsonArray == null || jsonArray.length() == 0) {
            // default image, artist has none
            return new SpotifyImage("C:/Development/Java/API/spotstat/src/main/resources/static/images/defultImage.png");
        }
        return new SpotifyImage(jsonArray.getJSONObject(0).getString("url"));
    }


    private String[] fromJsonToStringArray(JSONArray jsonArray) {
        if (jsonArray == null) return null;
        String[] strings = new String[jsonArray.length()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = jsonArray.getString(i);
        }
        return strings;
    }

    private TrackAlbumArtist[] fromJsonToAlbumArtistArray(JSONArray jsonArray) {
        if (jsonArray == null) return null;
        TrackAlbumArtist[] trackAlbumArtists = new TrackAlbumArtist[jsonArray.length()];
        for (int i = 0; i < trackAlbumArtists.length; i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            trackAlbumArtists[i] = new TrackAlbumArtist(json.getJSONObject("external_urls").getString("spotify"),
                    json.getString("href"), json.getString("id"), json.getString("name"), json.getString("type"),
                    json.getString("uri"));
        }
        return trackAlbumArtists;
    }

    private SpotifyImage[] fromJsonToImageArray(JSONArray jsonArray) {
        if (jsonArray == null) return null;
        SpotifyImage[] spotifyImages = new SpotifyImage[jsonArray.length()];
        for (int i = 0; i < Math.min(1, spotifyImages.length); i++) {
            spotifyImages[i] = new SpotifyImage(jsonArray.getJSONObject(i).getString("url"));
        }
        return spotifyImages;
    }

    private Market[] fromJsonToMarketArray(JSONArray jsonArray) {
        if (jsonArray == null) return null;
        Market[] markets = new Market[jsonArray.length()];
        for (int i = 0; i < markets.length; i++) {
            markets[i] = Market.valueOf(jsonArray.getString(i));
        }
        return markets;
    }

    private float[] fromJsonToFloatArray(JSONArray jsonArray) {
        if (jsonArray == null) return null;
        float[] floats = new float[jsonArray.length()];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = (float) jsonArray.getDouble(i);
        }
        return floats;
    }

    public Track serializeTrack(JSONObject json) {
        TrackAlbum trackAlbum = this.serializeTrackAlbum(json.getJSONObject("album"));
        TrackArtist[] trackArtists = this.serializeTrackArtists(json.getJSONArray("artists"));
        Market[] markets = this.fromJsonToMarketArray(json.getJSONArray("available_markets"));
        return new Track(trackAlbum, trackArtists, markets, json.getInt("disc_number"), json.getInt("duration_ms"),
                json.getBoolean("explicit"), null, json.getJSONObject("external_urls").getString("spotify"),
                json.getString("href"), json.getString("id"), json.getBoolean("is_playable"), null, null,
                json.getString("name"), json.getInt("popularity"), json.getString("preview_url"), json.getInt("track_number"),
                json.getString("type"), json.getString("uri"), json.getBoolean("is_local"));
    }

    private Track[] serializeTracks(JSONArray json) {
        if (json == null || json.length() == 0) return null;
        Track[] tracks = new Track[json.length()];
        for (int i = 0; i < tracks.length; i++) {
            Track track = this.serializeTrack(json.getJSONObject(i));
            tracks[i] = track;
        }
        return tracks;
    }

    private String getOptionalResponse(JSONObject json, String key) {
        if (json == null) return null;
        try {
            return json.getString(key);
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject getJsonOptionalResponse(JSONObject json, String key) {
        if (json == null) return null;
        try {
            return json.getJSONObject(key);
        } catch (JSONException e) {
            return null;
        }
    }


    public SearchResult serializeSearchResult(JSONObject json) {
        JSONObject jsonArtists = json.getJSONObject("artists");
        JSONObject jsonTracks = json.getJSONObject("tracks");
        if (jsonArtists == null && jsonTracks == null) return null;


        TrackArtist[] trackArtists = jsonArtists != null ? this.serializeTrackArtists(jsonArtists.getJSONArray("items")) : null;
        Track[] tracks = jsonTracks != null ? this.serializeTracks(jsonTracks.getJSONArray("items")) : null;
        return new SearchResult(trackArtists, tracks);
    }

}
