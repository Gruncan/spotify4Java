package com.spotify.objects;

import com.spotify.json.JSONArray;
import com.spotify.json.JSONObject;
import com.spotify.objects.track.TrackAudioAnalysis;
import com.spotify.objects.user.SpotifyUser;

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

        return new SpotifyUser(json.getString("country"), json.getString("display_name"), json.getString("email"), expContentArr, externalUrlsSpotify, followers,
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


    private float[] fromJsonToFloatArray(JSONArray jsonArray) {
        float[] floats = new float[jsonArray.length()];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = (float) jsonArray.getDouble(i);
        }
        return floats;
    }


}
