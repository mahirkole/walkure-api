package com.mahirkole.walkure.model;

import com.mahirkole.walkure.util.ImageIdConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "MovieCollection")
@Table(name = "movie_collection")
public class MovieCollection {

  @Id
  @Column(name = "collectionId")
  private Long id;

  @Column(name = "collectionName")
  private String name;

  @Lob
  @Column(name = "collectionOverview")
  private String overview;

  @Convert(converter = ImageIdConverter.class)
  @Column(name = "collectionPosterId")
  private Image poster;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "movie_id")
  private List<Movie> movieList;
}
