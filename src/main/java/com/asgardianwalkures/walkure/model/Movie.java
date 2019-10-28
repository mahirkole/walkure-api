package com.asgardianwalkures.walkure.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** Created by Burak Köken on 22.7.2019. Refactored by Mahir Köle on 03.08.2019. */
@Data
@Entity(name = "Movie")
@Table(name = "movie")
// @SQLDelete(sql = "UPDATE title SET deleted_at = CURRENT_TIMESTAMP WHERE title_id = ?")
public class Movie extends Title {

  @Id
  @GeneratedValue
  @Column(name = "movie_id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "movieRuntime")
  private Integer runtime;

  @Column(name = "movieBudget")
  private Integer budget;

  @Column(name = "movieImdbId")
  private String imdbId;

  @Column(name = "movieIsAdult")
  private Boolean isAdult;

  @Column(name = "movieReleaseDate")
  @Temporal(TemporalType.DATE)
  private Date releaseDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movie_collection_id")
  private MovieCollection movieCollection;

  @OneToMany(mappedBy = "movie", orphanRemoval = true, fetch = FetchType.LAZY)
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private List<MovieCrew> crewList = new ArrayList<>();

  @OneToMany(mappedBy = "movie", orphanRemoval = true, fetch = FetchType.LAZY)
  @JsonManagedReference
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private List<MovieCast> castList = new ArrayList<>();

  public void addCrewMember(Person person, String department, String job) {
    MovieCrew member = new MovieCrew();
    member.setPerson(person);
    member.setDepartment(department);
    member.setJob(job);
    this.crewList.add(member);
  }

  public void addCastMember(Person person, String character, Integer order) {
    MovieCast member = new MovieCast();
    member.setPerson(person);
    member.setCharacter(character);
    member.setOrder(order);
    this.castList.add(member);
  }
}
