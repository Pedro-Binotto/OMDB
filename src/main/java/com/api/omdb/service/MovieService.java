package com.api.omdb.service;

import com.api.omdb.client.MovieClient;
import com.api.omdb.converter.MovieConverter;
import com.api.omdb.dto.MovieDTO;
import com.api.omdb.model.Movie;
import com.api.omdb.repository.MovieRepository;
import com.api.omdb.vo.MovieOMDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Value("${omdb.apikey}") //pega do application.properties
    private String apiKey;
    @Autowired
    private MovieClient movieClient;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieConverter movieConverter;

    public MovieOMDB getMovie(String tema){
        return movieClient.getMovie(tema, apiKey);
    }
    public Movie save (MovieDTO movieDTO){
        Movie movie = movieConverter.convertToMovie(movieDTO);
                return movieRepository.save(movie);
    }
    public Movie getById(Long id){
        return movieRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Filme não encontrado"));
    }

}
