package com.api.omdb.service;

import com.api.omdb.client.MovieClient;
import com.api.omdb.to.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Value("${omdb.apikey}") //pega do application.properties
    private String apiKey;
    @Autowired
    private MovieClient movieClient;

    public Movie getMovie(String tema){
        return movieClient.getMovie(tema, apiKey);
    }
}
