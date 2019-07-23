package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Cast")
@Table(name = "cast")
public class Cast extends CoreModel {

    @Id
    @Column(name = "castId")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;

    @Column(name = "castCharacter")
    private String character;

    @Column(name = "castOrder")
    private Integer order;

}
