package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Episode")
@Table(name = "tv_episode")
public class Episode extends CoreModel {

    @Id
    @Column(name = "episodeId")
    private Long id;

    @Column(name = "episodeName")
    private String name;

    @ManyToOne
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tvshow_id")
    private TVShow tvShow;

    private List<Crew> crewList;
    private List<Cast> castList;

}
