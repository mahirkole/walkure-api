package com.asgardianwalkures.walkure.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Person")
@Table(name = "person")
@Data
public class Person extends CoreModel {

    @Id
    @Column(name = "personId")
    private Long id;

    @Column(name = "personName")
    private String name;

    @Column(name = "personBirthday")
    private Date birthday;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "personGender")
    private Gender gender;

    @Lob
    @Column(name = "personBio")
    private String bio;

    @Column(name = "personBirthPlace")
    private String birthPlace;

    @URL
    @Column(name = "personHomePageUrl")
    private String homepage;

    private Image image;

}
