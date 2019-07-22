package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Crew")
@Table(name = "crew")
public class Crew extends CoreModel {

    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;
    private String department;
    private Integer job;
}
