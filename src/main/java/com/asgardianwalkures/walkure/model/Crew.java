package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Crew")
@Table(name = "crew")
public class Crew extends CoreModel {

    @Id
    @Column(name = "crewId")
    private Long id;

    private Person person;

    @Column(name = "crewDepartment")
    private String department;

    @Column(name = "crewJob")
    private Integer job;

}
