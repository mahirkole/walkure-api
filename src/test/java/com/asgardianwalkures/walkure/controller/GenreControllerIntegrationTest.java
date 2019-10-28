package com.asgardianwalkures.walkure.controller;

import com.asgardianwalkures.walkure.dto.creation.GenreCreationDto;
import com.asgardianwalkures.walkure.exception.AlreadyExistsException;
import com.asgardianwalkures.walkure.model.Genre;
import com.asgardianwalkures.walkure.service.GenreService;
import com.asgardianwalkures.walkure.util.EndpointConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GenreController.class)
public class GenreControllerIntegrationTest {

  private ObjectMapper objectMapper = new ObjectMapper();
  @Autowired private MockMvc mockMvc;
  @MockBean private GenreService genreService;

  @Test
  public void givenGenres_whenGetGenres_thenReturnJsonArray() throws Exception {
    Genre testGenre = new Genre();
    testGenre.setName("Test Genre1");

    List<Genre> allGenres = Collections.singletonList(testGenre);

    given(genreService.getAllGenres()).willReturn(allGenres);

    mockMvc
        .perform(get(EndpointConstants.GENRE).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].name").value(testGenre.getName()))
        .andExpect(jsonPath("$[0].id").isNotEmpty());
  }

  @Test
  public void it_should_return_created_genre() throws AlreadyExistsException, Exception {
    GenreCreationDto genreCreationDto = new GenreCreationDto();
    genreCreationDto.setName("Aksiyon");

    Genre genre = new Genre();
    genre.setName(genreCreationDto.getName());

    when(genreService.createNewGenre(any(Genre.class))).thenReturn(genre);

    mockMvc
        .perform(
            post("/genre/")
                .content(objectMapper.writeValueAsBytes(genreCreationDto))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value(genreCreationDto.getName()))
        .andExpect(jsonPath("$.id").isNotEmpty());
  }
}
