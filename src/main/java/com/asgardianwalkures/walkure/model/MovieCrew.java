package com.asgardianwalkures.walkure.model;

import javax.persistence.*;

@Entity(name = "MovieCrew")
@DiscriminatorValue("movie")
public class MovieCrew extends Crew {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
