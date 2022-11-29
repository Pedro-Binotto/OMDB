package com.api.omdb.client;

import com.api.omdb.to.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="omdbMovies", url = "http://www.omdbapi.com/")
public interface MovieClient {

    @RequestMapping(method = RequestMethod.GET)
    Movie getMovie(@RequestParam("t") String tema, @RequestParam("apiKey")String key);
}
