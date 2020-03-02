package com.mahirkole.walkure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Season extends CoreModel {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_show_id")
    private TVShow tvShow;

    private String name;

    private Integer seasonNo;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "season_image",
            joinColumns = @JoinColumn(name = "season_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Image> images;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "season_video",
            joinColumns = @JoinColumn(name = "season_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id")
    )
    private Set<Video> videos;

    @OneToMany(mappedBy = "season")
    private Set<SeasonOverview> overviews;

    @Temporal(TemporalType.DATE)
    private Date airDate;

    @OneToMany(mappedBy = "season")
    private Set<SeasonCast> cast;

    @OneToMany(mappedBy = "season")
    private Set<SeasonCrew> crew;

    @OneToMany(mappedBy = "season")
    private Set<Episode> episodes;
}
