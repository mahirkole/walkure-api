package com.mahirkole.walkure.controller;

import com.mahirkole.walkure.annotation.MapperAspect;
import com.mahirkole.walkure.dto.creation.GenreCreationDto;
import com.mahirkole.walkure.exception.AlreadyExistsException;
import com.mahirkole.walkure.exception.NotFoundException;
import com.mahirkole.walkure.model.Genre;
import com.mahirkole.walkure.service.GenreService;
import com.mahirkole.walkure.util.EndpointConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndpointConstants.GENRE)
public class GenreController {

  private final GenreService genreService;

  @Autowired
  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @MapperAspect
  @PostMapping("/")
  public ResponseEntity<Genre> createNewGenre(@RequestBody GenreCreationDto genreCreationDto)
      throws AlreadyExistsException {
    Genre genre = new Genre();
    genre.setName(genreCreationDto.getName());
    return new ResponseEntity<>(genreService.createNewGenre(genre), HttpStatus.CREATED);
  }

  @MapperAspect
  @GetMapping("/{id}")
  public ResponseEntity<Genre> getGenreById(@PathVariable Long id) throws NotFoundException {
    return new ResponseEntity<>(genreService.getGenreById(id), HttpStatus.FOUND);
  }

  @MapperAspect
  @PutMapping("/{id}")
  public ResponseEntity<Genre> updateGenreById(
      @PathVariable Long id, @RequestBody GenreCreationDto genreCreationDto)
      throws NotFoundException, AlreadyExistsException {
    Genre genre = new Genre();
    genre.setId(id);
    genre.setName(genreCreationDto.getName());
    return new ResponseEntity<>(genreService.updateGenre(genre), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteGenreById(@PathVariable Long id) throws NotFoundException {
    genreService.deleteGenre(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
  }

  @MapperAspect
  @GetMapping("/")
  public ResponseEntity<List<Genre>> getAllGenres(@RequestParam(required = false) String name) {
    if (name != null) {
      return new ResponseEntity<>(genreService.getGenresByNameLike(name), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(genreService.getAllGenres(), HttpStatus.OK);
    }
  }
}
