package com.asgardianwalkures.walkure;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Movie")
@Table(name = "movie")
public class Movie {

    @Id
    private Long id;

    private String title;

}
