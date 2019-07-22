package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Cast")
@Table(name = "cast")
public class Cast extends CoreModel {
    @Id
    private Long id;
    private Person person;
    private String character;
    private Integer order;
}
