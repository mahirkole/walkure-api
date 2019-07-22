package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Cast")
@Table(name = "cast")
public class Cast extends CoreModel {

    @Id
    @Column(name = "castId")
    private Long id;

    private Person person;

    @Column(name = "castCharacter")
    private String character;

    @Column(name = "castOrder")
    private Integer order;

}
