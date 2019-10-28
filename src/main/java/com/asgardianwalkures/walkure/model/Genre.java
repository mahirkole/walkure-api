package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Genre")
@Table(name = "genre")
public class Genre extends CoreModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name", unique = true)
  private String name;

  public Genre() {}

  public Genre(String name) {
    this.name = name;
  }
}
