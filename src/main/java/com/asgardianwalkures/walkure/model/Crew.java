package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Crew")
@Table(name = "crew")
public class Crew extends CoreModel {

    @Id
    private Long id;
    private Person person;
    private String department;
    private Integer job;
}
