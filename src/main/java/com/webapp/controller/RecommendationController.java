package com.webapp.controller;

import com.spotify.SpotifyClient;
import com.webapp.algorithm.RecommendationAlgorithm;
import com.webapp.algorithm.TrackAlgInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecommendationController {


    @GetMapping("/recalg/")
    public String recommendationAlg() {
        SpotifyClient spotifyClient = com.webapp.controller.Controller.scb.getBuiltClient();

        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm(spotifyClient);
        List<TrackAlgInfo> trackAlgInfoList = TrackAlgInfo.loadFromFile("data.csv");
        recommendationAlgorithm.loadTracks(trackAlgInfoList);
        recommendationAlgorithm.acousticness();

        return "TestPage";
    }


}
