package com.webapp.controller;

import com.spotify.SpotifyClient;
import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.search.SearchGet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {


    @GetMapping("/search")
    public String viewSearch(Model model) {
        model.addAttribute("search", new Search());
        return "spotify-search";
    }

    @PostMapping("/search")
    public RedirectView search(@ModelAttribute("search") Search search, RedirectAttributes redirectAttributes) {
        System.out.println(search);

        final RedirectView redirectView = new RedirectView("/search", true);
        SpotifyClient spotifyClient = com.webapp.controller.Controller.scb.getBuiltClient();

        AbstractRequest searchRequest = new SearchGet(search.getValue(), "track,artist");
        JSONObject jsonObject = spotifyClient.executeRequest(searchRequest);
        System.out.println(jsonObject.toString());


        //SearchResult searchResult = new SerializeObject().serializeSearchResult(jsonObject);
        //redirectAttributes.addFlashAttribute("results", searchResult);
        //redirectAttributes.addFlashAttribute("success", true);
        return redirectView;

    }


}
