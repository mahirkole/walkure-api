package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Crew")
@Table(name = "crew")
public class Crew extends CoreModel {

    @Id
    @Column(name = "crewId")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;

    @Column(name = "crewDepartment")
    private String department;

    @Column(name = "crewJob")
    private Integer job;

}
