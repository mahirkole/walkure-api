package com.asgardianwalkures.walkure.controller;

import com.asgardianwalkures.walkure.dto.creation.PersonCreationDto;
import com.asgardianwalkures.walkure.exception.NotFoundException;
import com.asgardianwalkures.walkure.mapper.PersonMapper;
import com.asgardianwalkures.walkure.model.Person;
import com.asgardianwalkures.walkure.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

  @Autowired PersonService personService;

  @GetMapping("/person/{id}")
  public ResponseEntity<Person> getPersonById(@PathVariable Long id) throws NotFoundException {
    return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.FOUND);
  }

  @PostMapping("/person")
  public ResponseEntity<Person> createPerson(@RequestBody PersonCreationDto personCreationDto) {
    Person person = PersonMapper.INSTANCE.toModel(personCreationDto);
    return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
  }

  @GetMapping("/person")
  public ResponseEntity<List<Person>> getPeopleByName(@RequestParam("name") String name) {
    return new ResponseEntity<>(personService.findPeopleByName(name), HttpStatus.OK);
  }

  public ResponseEntity<Person> updatePersonById() {
    return null;
  }

  public void deletePersonById() {}
}
