package com.mahirkole.walkure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Movie extends Title {

    private Boolean isAdult;
    private Boolean isVideo;
    private Integer budget;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    private Integer revenue;
    private Integer runtime;
    private String tagline;

    @OneToMany(mappedBy = "movie")
    private Set<MovieCast> cast;

    @OneToMany(mappedBy = "movie")
    private Set<MovieCrew> crew;
}