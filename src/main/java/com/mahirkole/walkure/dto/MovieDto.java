package com.mahirkole.walkure.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieDto extends TitleDto {

  private Long titleId;
  private String name;
  private String homepage;
  private ImageDto poster;
  private String overview;
  private String language;
  private Integer runtime;
  private Integer budget;
  private String imdbId;
  private Boolean isAdult;
  private String releaseDate;
  private MovieCollectionDto movieCollection;
  private List<GenreDto> genres;
  private List<CompanyDto> companies;
}
