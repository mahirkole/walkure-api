package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Genre")
@Table(name = "genre")
public class Genre {
    @Id
    private Long id;
    private String genre;
}
