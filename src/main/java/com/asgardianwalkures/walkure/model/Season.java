package com.asgardianwalkures.walkure.model;

import com.asgardianwalkures.walkure.ImageIdConverter;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tvshow_id")
    private TVShow tvShow;

    @Column(name = "seasonName")
    private String name;

    @Column(name = "seasonNo")
    private Integer seasonNo;

    @Convert(converter = ImageIdConverter.class)
    @Column(name = "seasonPoster")
    private Image poster;

    @Column(name = "seasonTvShowId")
    private Long tvShowId;

    @Column(name = "seasonOverview")
    private String overview;

    @Temporal(TemporalType.DATE)
    @Column(name = "seasonAirDate")
    private Date airDate;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodeList;

}
