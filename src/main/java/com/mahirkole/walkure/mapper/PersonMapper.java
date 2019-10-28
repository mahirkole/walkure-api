package com.mahirkole.walkure.mapper;

import com.mahirkole.walkure.dto.PersonDto;
import com.mahirkole.walkure.dto.creation.PersonCreationDto;
import com.mahirkole.walkure.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper extends CoreMapper<Person, PersonDto> {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  @Override
  PersonDto toDto(Person Person);

  @Override
  Person toModel(PersonDto target);

  @Override
  List<Person> toModel(List<PersonDto> targetList);

  @Override
  List<PersonDto> toDto(List<Person> sourceList);

  @Mapping(target = "birthday", dateFormat = "yyyy-MM-dd")
  Person toModel(PersonCreationDto PersonCreationDto);
}
