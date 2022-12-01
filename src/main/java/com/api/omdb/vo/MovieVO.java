package com.api.omdb.vo;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class MovieVO extends RepresentationModel<MovieVO> {
    private Long id;
    private String title;
    private String year;
}
