package com.mahirkole.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Image")
@Table(name = "image")
public class Image extends CoreModel {

  @Id
  @Column(name = "imageId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "imageUrl")
  private String url;
}
