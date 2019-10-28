package com.asgardianwalkures.walkure.repository;

import com.asgardianwalkures.walkure.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {}
