package com.mahirkole.walkure.repository;

import com.mahirkole.walkure.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  Optional<Person> findPersonById(Long personId);

  List<Person> findPeopleByNameIsLike(String name);
}
