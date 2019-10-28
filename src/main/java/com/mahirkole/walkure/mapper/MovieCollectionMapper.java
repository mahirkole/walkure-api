package com.mahirkole.walkure.mapper;

import com.mahirkole.walkure.dto.MovieCollectionDto;
import com.mahirkole.walkure.model.MovieCollection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieCollectionMapper {

  MovieCollectionMapper INSTANCE = Mappers.getMapper(MovieCollectionMapper.class);

  @Mapping(target = "poster", source = "poster")
  MovieCollectionDto movieCollectionToMovieCollectionDto(MovieCollection movieCollection);
}
