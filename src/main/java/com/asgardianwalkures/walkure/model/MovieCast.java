package com.asgardianwalkures.walkure.model;

import javax.persistence.*;

@Entity(name = "MovieCast")
@DiscriminatorValue("movie")
public class MovieCast extends Casts {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
