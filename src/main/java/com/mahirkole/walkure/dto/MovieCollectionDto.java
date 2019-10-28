package com.mahirkole.walkure.dto;

import lombok.Data;

@Data
public class MovieCollectionDto {

  private Long id;
  private String name;
  private String overview;
  private ImageDto poster;
}
