package com.api.omdb.controller;

import com.api.omdb.converter.MovieConverter;
import com.api.omdb.dto.MovieDTO;
import com.api.omdb.service.MovieService;
import com.api.omdb.vo.MovieOMDB;
import com.api.omdb.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.rsa.crypto.RsaAlgorithm;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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

    @PostMapping
    public ResponseEntity<MovieVO> saveMovie (@RequestBody MovieDTO movieDTO){
        try{
            MovieVO movieVO = movieConverter.convertToMovieVO(movieService.save(movieDTO)); //MovieService.Save chama as informações de Movie, que passa para o controller como parametro para o converter, que por sua vez converte para MovieVO.
            addHateoas(movieVO);
            return ResponseEntity.status(HttpStatus.CREATED).body(movieVO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private void addHateoas(MovieVO movieVO){
        movieVO.add(linkTo(methodOn(MovieController.class).getById(movieVO.getId()))
                .withSelfRel());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieVO> getById(@PathVariable("id") Long id){
        try{
            MovieVO movieVO = movieConverter.convertToMovieVO(movieService.getById(id));
            return ResponseEntity.ok(movieVO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
//requisições mandando MovieDTO recebem informações do MovieClient, pra retornar as informações para a tela, usa MovieVO (View Object)
//Postman>MovieDTO>MovieVO
//single responsability
