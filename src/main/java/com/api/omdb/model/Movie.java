package com.api.omdb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="titulo")
    private String title;
    @Column(name="ano")
    private String Year;
}
