package com.asgardianwalkures.walkure;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Movie")
@Table(name = "movie")
public class Movie {

    private String title;

}
