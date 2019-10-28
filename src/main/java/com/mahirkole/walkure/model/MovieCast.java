package com.mahirkole.walkure.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "MovieCast")
@DiscriminatorValue("movie")
@Data
public class MovieCast extends Casts {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movie_id")
  @JsonBackReference
  private Movie movie;
}
