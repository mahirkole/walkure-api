package com.mahirkole.walkure.mapper;

import com.mahirkole.walkure.dto.MovieDto;
import com.mahirkole.walkure.dto.creation.MovieCreationDto;
import com.mahirkole.walkure.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
    uses = {MovieCompanyMapper.class, GenreMapper.class, MovieCollectionMapper.class},
    componentModel = "spring")
public interface MovieMapper extends CoreMapper<Movie, MovieDto> {

  MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

  @Mapping(target = "titleId", source = "id")
  @Mapping(target = "poster", source = "poster")
  MovieDto toDto(Movie movie);

  @Mapping(target = "id", source = "titleId")
  @Mapping(target = "poster", source = "poster")
  Movie toModel(MovieDto movieDto);

  List<MovieDto> toDto(List<Movie> sourceList);

  List<Movie> toModel(List<MovieDto> targetList);

  @Mapping(target = "releaseDate", dateFormat = "yyyy-MM-dd")
  Movie toModel(MovieCreationDto movieCreationDto);
}
