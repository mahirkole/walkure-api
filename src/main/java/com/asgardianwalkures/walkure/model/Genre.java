package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Genre")
@Table(name = "genre")
public class Genre {

    @Id
    @Column(name = "genreId")
    private Long id;

    @Column(name = "genreName")
    private String genre;

    @ManyToMany
    private List<Movie> movieList;

}
