package com.mahirkole.walkure.dto.creation;

import lombok.Data;

import java.util.List;

@Data
public class MovieCreationDto extends TitleCreationDto {

  private String name;
  private String homepage;
  private Long posterId;
  private String overview;
  private String language;
  private Integer runtime;
  private Integer budget;
  private String imdbId;
  private Boolean isAdult;
  private String releaseDate;
  private Long movieCollectionId;
  private List<Long> genreIds;
  private List<Long> companyIds;
}
