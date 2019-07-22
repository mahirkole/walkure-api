package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity(name = "Episode")
@Table(name = "tv_episode")
public class Episode extends CoreModel {

    @Id
    private Long id;
    private Season season;
    private TVShow tvShow;
    private String name;
    private List<Crew> crewList;
    private List<Cast> castList;

}
