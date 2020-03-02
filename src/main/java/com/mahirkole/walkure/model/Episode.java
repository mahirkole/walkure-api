package com.mahirkole.walkure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Episode extends CoreModel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToOne
    @JoinColumn(name = "tv_show_id")
    private TVShow tvShow;

    @Temporal(TemporalType.DATE)
    private Date airDate;

    @OneToMany(mappedBy = "episode")
    private Set<EpisodeOverview> overviews;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "episode_image",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Image> images;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "episode_video",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id")
    )
    private Set<Video> videos;

    @OneToMany(mappedBy = "episode")
    private Set<EpisodeCast> cast;

    @OneToMany(mappedBy = "episode")
    private Set<EpisodeCast> guests;

    @OneToMany(mappedBy = "episode")
    private Set<EpisodeCrew> crew;
}
