package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "MovieCrew")
@DiscriminatorValue("movie")
@Data
public class MovieCrew extends Crew {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movie_id")
  private Movie movie;
}
