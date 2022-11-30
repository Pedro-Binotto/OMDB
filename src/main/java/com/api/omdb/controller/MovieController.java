package com.api.omdb.controller;

import com.api.omdb.converter.MovieConverter;
import com.api.omdb.dto.MovieDTO;
import com.api.omdb.service.MovieService;
import com.api.omdb.vo.MovieOMDB;
import com.api.omdb.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService; //atributo movieService

    @Autowired
    private MovieConverter movieConverter;

    @GetMapping("/omdb/{tema}")
    public ResponseEntity<MovieOMDB> getMovie(@PathVariable String tema){
    try{
        MovieOMDB movieOMDB = movieService.getMovie(tema);
        return ResponseEntity.status(HttpStatus.OK).body(movieOMDB);
    }
    catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }
    /*
    @PostMapping
    public ResponseEntity<MovieVO> saveMovie (@RequestBody MovieDTO movieDTO){
        try{
            MovieVO movieVO = movieConverter.convertToMovieVO(movieService.save(movieDTO));
            addHateoas(movieVO);
            return ResponseEntity.status(HttpStatus.CREATED).body(movieVO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private void addHateoas(MovieVO movieVO){
        movieVO.add(linkTO(methodOn(MovieController.class).getById(movieVO.getId()))
                .withSelfRel());
    }*/

}