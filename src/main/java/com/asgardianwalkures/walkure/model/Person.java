package com.asgardianwalkures.walkure.model;

import com.asgardianwalkures.walkure.util.ImageIdConverter;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Person")
@Table(name = "person")
@Data
public class Person extends CoreModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "person_id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "personName", nullable = false)
  private String name;

  @Column(name = "personBirthday")
  private Date birthday;

  // @Enumerated(EnumType.ORDINAL)
  @Column(name = "personGender")
  private String gender;
  // private Gender gender;

  @Lob
  @Column(name = "personBio")
  private String bio;

  @Column(name = "personBirthPlace")
  private String birthPlace;

  @URL
  @Column(name = "personHomePageUrl")
  private String homepage;

  @Convert(converter = ImageIdConverter.class)
  @Column(name = "personImageId")
  private Image image;
}
