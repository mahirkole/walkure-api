package com.mahirkole.walkure.mapper;

import com.mahirkole.walkure.dto.MovieCompanyDto;
import com.mahirkole.walkure.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieCompanyMapper {

  MovieCompanyMapper INSTANCE = Mappers.getMapper(MovieCompanyMapper.class);

  @Mapping(target = "parent", ignore = true)
  @Mapping(target = "description", ignore = true)
  @Mapping(target = "country", ignore = true)
  @Mapping(target = "homepage", ignore = true)
  MovieCompanyDto companyToCompanyDto(Company company);
}
