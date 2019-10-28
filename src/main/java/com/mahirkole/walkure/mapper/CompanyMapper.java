package com.mahirkole.walkure.mapper;

import com.mahirkole.walkure.dto.CompanyDto;
import com.mahirkole.walkure.dto.creation.CompanyCreationDto;
import com.mahirkole.walkure.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends CoreMapper<Company, CompanyDto> {

  CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

  @Override
  CompanyDto toDto(Company company);

  @Override
  Company toModel(CompanyDto target);

  @Override
  List<Company> toModel(List<CompanyDto> targetList);

  @Override
  List<CompanyDto> toDto(List<Company> sourceList);

  Company toModel(CompanyCreationDto companyCreationDto);
}
