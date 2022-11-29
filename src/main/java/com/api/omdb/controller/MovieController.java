package com.api.omdb.controller;

import com.api.omdb.service.MovieService;
import com.api.omdb.to.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService; //atributo movieService

    @GetMapping("/omdb/{tema}")
    public ResponseEntity<Movie> getMovie(@PathVariable String tema){
    try{
        Movie movie = movieService.getMovie(tema);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }
    catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    }

}
