package com.mahirkole.walkure.service;

import com.mahirkole.walkure.exception.NotFoundException;
import com.mahirkole.walkure.model.Genre;
import com.mahirkole.walkure.repository.GenreRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class GenreServiceIntegrationTest {

    @TestConfiguration
    static class GenreServiceIntegrationTestContextConfiguration {

        @Bean
        public GenreService genreService() {
            return new GenreService();
        }
    }

    @Autowired
    private GenreService genreService;

    @MockBean
    private GenreRepository genreRepository;

    @Before
    public void setUp() {
        Genre testGenre = new Genre();
        testGenre.setName("Test Genre");

        Mockito.when(genreRepository.findByName(testGenre.getName()))
                .thenReturn(Optional.of(testGenre));
    }

    @Test
    public void whenValidName_thenGenreShouldBeFound() {
        String name = "Test Genre";
        Genre foundGenre = null;
        try {
            foundGenre = genreService.getGenreByName(name);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(foundGenre.getName()).isEqualTo(name);
        }
    }

}
