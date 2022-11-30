package com.api.omdb.client;

import com.api.omdb.vo.MovieOMDB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="omdbMovies", url = "https://www.omdbapi.com/")
public interface MovieClient {

    @RequestMapping(method = RequestMethod.GET)
    MovieOMDB getMovie(@RequestParam("t") String tema, @RequestParam("apiKey")String key);
}
