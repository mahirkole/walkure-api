package com.mahirkole.walkure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Genre extends CoreModel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
