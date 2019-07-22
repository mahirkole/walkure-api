package com.asgardianwalkures.walkure.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "Person")
@Table(name = "person")
@Data
public class Person extends CoreModel {

    @Id
    private Long id;
    private String name;
    private Date birthday;
    private Image image;
    private String gender;
    private String bio;
    private String birthPlace;
    private String imdbId;
    @URL
    private String homepage;
}
