package com.asgardianwalkures.walkure.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Burak Köken on 22.7.2019.
 */
@Entity(name = "Movie")
public class Movie {

    @Id
    @Column(name = "movieId")
    private Long id;

    @Column(name = "movieTitle")
    private String title;

    @Column(name = "movieRuntime")
    private int runtime;

    @Column(name = "movieImdb")
    private double imdb;

    @Column(name = "movieAdult")
    private boolean adult;

    @Column(name = "movieReleaseDate")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToMany
    private List<Genre> genreList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}
