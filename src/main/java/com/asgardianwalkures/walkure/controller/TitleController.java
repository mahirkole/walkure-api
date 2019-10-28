package com.asgardianwalkures.walkure.controller;

import com.asgardianwalkures.walkure.annotation.MapperAspect;
import com.asgardianwalkures.walkure.dto.creation.MovieCreationDto;
import com.asgardianwalkures.walkure.exception.NotFoundException;
import com.asgardianwalkures.walkure.mapper.MovieMapper;
import com.asgardianwalkures.walkure.model.Movie;
import com.asgardianwalkures.walkure.model.Title;
import com.asgardianwalkures.walkure.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TitleController {

  @Autowired private TitleService titleService;

  @GetMapping("/title")
  public List<Title> getAllTitles() {
    return titleService.getAllTitles();
  }

  @MapperAspect
  @GetMapping("/title/{titleId}")
  public ResponseEntity getTitleById(@PathVariable Long titleId) throws NotFoundException {
    Title title = titleService.getTitleById(titleId);

    if (title instanceof Movie) {
      return ResponseEntity.status(HttpStatus.FOUND).body(title);
    } else {
      // TODO: TVShow dönecek
      return ResponseEntity.status(HttpStatus.FOUND).body(title);
    }
  }

  @MapperAspect
  @PostMapping("/movie")
  public ResponseEntity<Movie> createNewMovie(@RequestBody MovieCreationDto movieCreationDto) {
    Movie movie = MovieMapper.INSTANCE.toModel(movieCreationDto);
    return new ResponseEntity(titleService.createTitle(movie), HttpStatus.CREATED);
  }
}
