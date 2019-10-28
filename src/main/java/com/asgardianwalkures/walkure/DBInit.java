package com.asgardianwalkures.walkure;

import com.asgardianwalkures.walkure.model.*;
import com.asgardianwalkures.walkure.repository.*;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Component
public class DBInit implements CommandLineRunner {

  @Autowired private TitleRepository titleRepository;

  @Autowired private PersonRepository personRepository;

  @Autowired private GenreRepository genreRepository;

  @Autowired private CompanyRepository companyRepository;

  @Autowired private ImageRepository imageRepository;

  @Bean
  private FakeValuesService fakeValuesService() {
    return new FakeValuesService(new Locale("tr"), new RandomService());
  }

  @Bean
  private Faker faker() {
    return new Faker(new Locale("tr"));
  }

  @Override
  public void run(String... args) throws Exception {
    generateMovie();
    // generateMovie();
    // generateMovie();
  }

  private Person generateUser() {
    Person person = new Person();
    person.setName(faker().name().fullName());
    person.setBio(faker().lorem().paragraph());
    person.setBirthday(faker().date().birthday());
    person.setBirthPlace(faker().country().name());
    // person.setGender(Gender.MALE);
    person.setHomepage("http://".concat(faker().internet().url()));
    person.setImage(generateAvatar());
    return person;
  }

  private Title generateMovie() {
    Title title = new Movie();
    title.setName(faker().funnyName().name());
    ((Movie) title).setImdbId("tt000001");
    ((Movie) title).setRuntime(120);
    ((Movie) title).setReleaseDate(faker().date().past(3 * 365, TimeUnit.DAYS));
    ((Movie) title).setBudget(faker().number().randomDigit());
    title.setOverview(faker().lorem().paragraphs(3).toString());
    title.setHomepage("http://".concat(faker().internet().url()));
    title.setLanguage(faker().nation().language());
    ((Movie) title).setIsAdult(faker().bool().bool());

    if (faker().random().nextInt(100) % 2 == 1) {
      title.addCompany(generateCompany());
    } else {
      title.addCompany(generateCompany());
    }

    title.addGenre(generateGenre());
    // title.addGenre(generateGenre());
    // title.addGenre(generateGenre());
    title.setPoster(generatePoster());

    for (int i = 0; i < 2; i++) {
      ((Movie) title).addCastMember(generatePerson(), faker().rickAndMorty().character(), i);
      ((Movie) title)
          .addCrewMember(
              generatePerson(), faker().commerce().department(), faker().company().profession());
    }

    return titleRepository.save(title);
  }

  /*
  private Title generateTvShow() {

  }*/

  private Company generateCompany() {
    Company company = new Company();
    company.setName(faker().company().name());
    company.setHomepage("http://".concat(faker().company().url()));
    company.setDescription(faker().lorem().paragraph());

    // if (faker().random().nextInt(100) % 5 == 1)
    //    company.addChildCompany(generateCompany());

    company.setCountry(faker().country().name());
    company.setLogo(generateLogo());
    return company;
    // return companyRepository.save(company);
  }

  private Genre generateGenre() {
    Genre genre = new Genre();
    genre.setName(faker().book().genre());
    return genre;
    // return genreRepository.save(genre);
  }

  private Image generateLogo() {
    Image image = new Image();
    image.setUrl(faker().company().logo());
    return imageRepository.save(image);
  }

  private Image generatePoster() {
    Image image = new Image();
    image.setUrl(faker().internet().image());
    return imageRepository.save(image);
  }

  private Image generateAvatar() {
    Image image = new Image();
    image.setUrl(faker().internet().avatar());
    return imageRepository.save(image);
  }

  private Person generatePerson() {
    Person person = new Person();
    person.setHomepage("http://".concat(faker().internet().url()));
    // person.setGender(faker().demographic().sex().equals("male") ? Gender.MALE : Gender.FEMALE);
    person.setImage(generateAvatar());
    person.setBirthPlace(faker().address().state());
    person.setBio(faker().lorem().paragraph());
    person.setName(faker().name().fullName());
    return personRepository.save(person);
  }
}
