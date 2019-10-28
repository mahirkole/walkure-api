package com.mahirkole.walkure.mapper;

import com.mahirkole.walkure.dto.GenreDto;
import com.mahirkole.walkure.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper extends CoreMapper<Genre, GenreDto> {

  GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

  GenreDto toDto(Genre genre);

  Genre toModel(GenreDto genreDto);

  List<GenreDto> toDto(List<Genre> genreCollection);

  List<Genre> toModel(List<GenreDto> genreDtoCollection);
}
