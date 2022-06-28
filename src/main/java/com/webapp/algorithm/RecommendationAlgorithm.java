package com.webapp.algorithm;

import com.spotify.SpotifyClient;
import com.spotify.json.JSONObject;
import com.spotify.objects.SerializeObject;
import com.spotify.objects.track.Track;
import com.spotify.objects.track.TrackAudioFeatures;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.tracks.TrackAudioFeaturesGet;
import com.spotify.requests.tracks.TrackGet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendationAlgorithm {


    private final SpotifyClient spotifyClient;
    private final Map<String, Track> tracks;
    private List<TrackAlgInfo> trackAlgInfos;

    public RecommendationAlgorithm(SpotifyClient spotifyClient) {
        this.spotifyClient = spotifyClient;
        this.tracks = new HashMap<>();
        this.trackAlgInfos = null;
    }


    public void loadTracks(List<TrackAlgInfo> trackInfo) {
        this.trackAlgInfos = trackInfo;
        SerializeObject serializeObject = new SerializeObject();

        for (TrackAlgInfo trackAlgInfo : trackInfo) {
            AbstractRequest getTrackData = new TrackGet(trackAlgInfo.getId());
            JSONObject trackJson = this.spotifyClient.executeRequest(getTrackData);
            //Track track = serializeObject.serializeTrack(trackJson);

            AbstractRequest getTrackFeatures = new TrackAudioFeaturesGet(trackAlgInfo.getId());
            JSONObject jsonFeatures = this.spotifyClient.executeRequest(getTrackFeatures);
            //TrackAudioFeatures trackAudioFeatures = serializeObject.serializeTrackAudioFeatures(jsonFeatures);
            //track.setAudioFeatures(trackAudioFeatures);


            //this.tracks.put(trackAlgInfo.getId(), track);


        }

    }


    public Track run() {
        if (this.trackAlgInfos == null) return null;
        return null;
    }

    public void acousticness() {
        for (Track track : this.tracks.values()) {
            TrackAudioFeatures trackAudioFeatures = track.getAudioFeatures();
            System.out.printf("Track: %s (%s) -> %s%n", track.getName(), track.getId(), trackAudioFeatures.getAcousticness());
        }
    }


}
