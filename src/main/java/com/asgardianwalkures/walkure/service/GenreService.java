package com.asgardianwalkures.walkure.service;

import com.asgardianwalkures.walkure.exception.AlreadyExistsException;
import com.asgardianwalkures.walkure.exception.NotFoundException;
import com.asgardianwalkures.walkure.model.Genre;
import com.asgardianwalkures.walkure.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

  @Autowired GenreRepository genreRepository;

  public Genre createNewGenre(Genre genre) throws AlreadyExistsException {
    try {
      if (getGenreByName(genre.getName()) != null) {
        throw new AlreadyExistsException(Genre.class, genre.getName());
      } else {
        return genreRepository.save(genre);
      }
    } catch (NotFoundException e) {
      return genreRepository.save(genre);
    }
  }

  public Genre updateGenre(Genre genre) throws NotFoundException, AlreadyExistsException {
    Genre existingGenre = getGenreById(genre.getId());

    try {
      getGenreByName(genre.getName());
      throw new AlreadyExistsException(Genre.class, genre.getName());
    } catch (NotFoundException ex) {
      existingGenre.setName(genre.getName());
      return genreRepository.save(existingGenre);
    }
  }

  public void deleteGenre(Long id) throws NotFoundException {
    try {
      genreRepository.delete(getGenreById(id));
    } catch (NotFoundException e) {
      throw new NotFoundException(Genre.class, id.toString());
    }
  }

  public Genre getGenreById(Long id) throws NotFoundException {
    return genreRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException(Genre.class, id.toString()));
  }

  public Genre getGenreByName(String name) throws NotFoundException {
    return genreRepository
        .findByName(name)
        .orElseThrow(() -> new NotFoundException(Genre.class, name));
  }

  public List<Genre> getGenresByNameLike(String name) {
    return genreRepository.findGenreByNameLike(name);
  }

  public List<Genre> getAllGenres() {
    return genreRepository.findAll();
  }
}
