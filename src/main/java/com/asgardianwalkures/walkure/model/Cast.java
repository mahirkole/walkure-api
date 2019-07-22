package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Cast")
@Table(name = "cast")
public class Cast extends CoreModel {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;
    private String character;
    private Integer order;
}
