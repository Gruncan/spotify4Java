package com.webapp.algorithm;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<TrackAlgInfo> data = TrackAlgInfo.loadFromFile("data.csv");

        for (TrackAlgInfo trackAlgInfo : data) {
            System.out.println(trackAlgInfo);
        }
    }


}
