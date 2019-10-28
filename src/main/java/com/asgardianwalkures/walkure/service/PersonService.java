package com.asgardianwalkures.walkure.service;

import com.asgardianwalkures.walkure.exception.NotFoundException;
import com.asgardianwalkures.walkure.model.Person;
import com.asgardianwalkures.walkure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

  @Autowired private PersonRepository personRepository;

  public Person getPersonById(Long id) throws NotFoundException {
    return personRepository
        .findPersonById(id)
        .orElseThrow(() -> new NotFoundException(Person.class, id.toString()));
  }

  public List<Person> findPeopleByName(String name) {
    return personRepository.findPeopleByNameIsLike(name);
  }

  public Person createPerson(Person person) {
    return personRepository.save(person);
  }
}
