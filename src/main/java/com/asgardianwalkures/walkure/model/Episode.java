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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "episode_crew")
    private Set<Crew> crewList;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "episode_cast")
    private Set<Cast> castList;

}
