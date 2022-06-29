package com.webapp.algorithm;

import com.spotify.json.JSONObject;

public class Main {


    public static void main(String[] args) {

        Boolean s = Boolean.TRUE;
        JSONObject jsonObject = new JSONObject(String.format("{\"value\": %b}", s));
        System.out.println(jsonObject);
//
//        JSONObject json = new JSONObject("{\"array\":[\"test1\",\"test2\", \"test3\", \"test4\" ]}");
//        JSONArray jsonArray = json.getJSONArray("array");
//        for (int i=0; i<jsonArray.length(); i++){
//            System.out.println(jsonArray.getJSONObject(i));
//        }


    }


}
