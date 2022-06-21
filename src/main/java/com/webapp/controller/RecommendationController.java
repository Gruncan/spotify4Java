package com.webapp.controller;

import com.spotify.SpotifyClient;
import com.spotify.json.JSONObject;
import com.spotify.requests.users.CurrentUserProfileGet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommendationController {


    @GetMapping("/recalg/")
    public String recommendationAlg() {
        SpotifyClient spotifyClient = com.webapp.controller.Controller.scb.getBuiltClient();

        CurrentUserProfileGet currentUserProfileGet = new CurrentUserProfileGet();
        JSONObject jsonObject = spotifyClient.executeRequest(currentUserProfileGet);
        System.out.println(jsonObject);
//        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm(spotifyClient);
//        List<TrackAlgInfo> trackAlgInfoList = TrackAlgInfo.loadFromFile("data.csv");
//        recommendationAlgorithm.loadTracks(trackAlgInfoList);
//        recommendationAlgorithm.acousticness();

        return "TestPage";
    }


}
