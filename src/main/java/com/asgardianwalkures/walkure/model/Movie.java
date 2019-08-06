package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Burak Köken on 22.7.2019.
 * Refactored by Mahir Köle on 03.08.2019.
 */
@Data
@Entity(name = "Movie")
@Table(name = "movie")
public class Movie extends Title {

    @Id
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "movieRuntime")
    private Integer runtime;

    @Column(name = "movieBudget")
    private Integer budget;

    @Column(name = "movieImdbId")
    private String imdbId;

    @Column(name = "movieIsAdult")
    private Boolean isAdult;

    @Column(name = "movieReleaseDate")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_collection_id")
    private MovieCollection movieCollection;
}
