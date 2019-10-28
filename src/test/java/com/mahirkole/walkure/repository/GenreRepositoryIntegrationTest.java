package com.mahirkole.walkure.repository;

import com.mahirkole.walkure.model.Genre;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GenreRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private GenreRepository genreRepository;

    //@Test
    public void whenFindByName_thenReturnGenre() {
        Genre testGenre = new Genre();
        testGenre.setName("Test Genre1");
        testEntityManager.persist(testGenre);
        testEntityManager.flush();

        Genre foundGenre = genreRepository.findByName(testGenre.getName()).get();

        assertThat(foundGenre.getName()).isEqualTo(testGenre.getName());
    }
}
