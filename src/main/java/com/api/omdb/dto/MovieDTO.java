package com.api.omdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieDTO {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
}
