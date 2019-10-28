package com.mahirkole.walkure.controller;

import com.mahirkole.walkure.annotation.MapperAspect;
import com.mahirkole.walkure.dto.creation.MovieCreationDto;
import com.mahirkole.walkure.exception.NotFoundException;
import com.mahirkole.walkure.mapper.MovieMapper;
import com.mahirkole.walkure.model.Movie;
import com.mahirkole.walkure.model.Title;
import com.mahirkole.walkure.service.TitleService;
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
