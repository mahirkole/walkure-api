package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "Episode")
@Table(name = "tv_episode")
public class Episode extends CoreModel {

    @Id
    @Column(name = "tvEpisodeId")
    private Long id;

    @Column(name = "tvEpisodeName")
    private String name;

    @ManyToOne
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tvshow_id")
    private TVShow tvShow;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EpisodeCrew> crewList;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EpisodeCast> castList;

}
