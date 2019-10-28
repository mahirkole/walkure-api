package com.mahirkole.walkure.service;

import com.mahirkole.walkure.exception.NotFoundException;
import com.mahirkole.walkure.model.Title;
import com.mahirkole.walkure.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleService {

  @Autowired private TitleRepository titleRepository;

  @Autowired private GenreService genreService;

  /**
   * Returns Title which has specified ID number
   *
   * @param titleId
   * @return Title with specified ID
   * @throws NotFoundException
   */
  public Title getTitleById(Long titleId) throws NotFoundException {
    Optional<Title> optionalTitle = titleRepository.findTitleById(titleId);
    return optionalTitle.orElseThrow(NotFoundException::new);
  }

  public Title createTitle(Title newTitle) {
    return titleRepository.save(newTitle);
  }

  public void deleteTitle(Title title) {
    titleRepository.delete(title);
  }

  public Title updateTitle(Title title) {
    return titleRepository.save(title);
  }

  public List<Title> getAllTitles() {
    return titleRepository.findAll();
  }
}
