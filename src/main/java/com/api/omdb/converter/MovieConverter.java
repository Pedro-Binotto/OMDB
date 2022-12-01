package com.api.omdb.converter;

import com.api.omdb.dto.MovieDTO;
import com.api.omdb.model.Movie;
import com.api.omdb.vo.MovieVO;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {
    public Movie convertToMovie(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setYear(movieDTO.getYear());
        return movie;
    }
    public MovieVO convertToMovieVO(Movie movie){
        MovieVO movieVO = new MovieVO();
        movieVO.setId(movie.getId());
        movieVO.setTitle(movie.getTitle());
        movieVO.setYear(movie.getYear());
        return movieVO;
    }

}
