package com.mahirkole.walkure.repository;

import com.mahirkole.walkure.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
  Optional<Title> findTitleById(Long titleId);
}
