package com.api.omdb.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieOMDB {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
}
