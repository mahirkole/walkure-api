package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Season")
@Table(name = "tv_season")
public class Season extends CoreModel {

    @Id
    @Column(name = "seasonId")
    private Long id;

    @Column(name = "seasonName")
    private String name;

    @Column(name = "seasonNo")
    private Integer seasonNo;

    @Column(name = "seasonTvShowId")
    private Long tvShowId;

    @Column(name = "seasonOverview")
    private String overview;

    private Image poster;

    @Temporal(TemporalType.DATE)
    @Column(name = "seasonAirDate")
    private Date airDate;

    @ManyToOne
    private TVShow tvShow;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodeList;

}
