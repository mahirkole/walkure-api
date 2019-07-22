package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Episode")
@Table(name = "tv_episode")
public class Episode extends CoreModel {

    @Id
    private Long id;
    private Season season;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tvshow_id")
    private TVShow tvShow;
    private String name;
    private List<Crew> crewList;
    private List<Cast> castList;

}
