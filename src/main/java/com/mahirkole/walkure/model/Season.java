package com.mahirkole.walkure.model;

import com.mahirkole.walkure.util.ImageIdConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Season")
@Table(name = "tv_season")
public class Season extends CoreModel {

  @Id
  @Column(name = "tvSeasonId")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tvshow_id")
  private TVShow tvShow;

  @Column(name = "tvSeasonName")
  private String name;

  @Column(name = "tvSeasonNo")
  private Integer seasonNo;

  @Convert(converter = ImageIdConverter.class)
  @Column(name = "tvSeasonPosterId")
  private Image poster;

  @Column(name = "tvSeasonTvShowId")
  private Long tvShowId;

  @Lob
  @Column(name = "tvSeasonOverview")
  private String overview;

  @Temporal(TemporalType.DATE)
  @Column(name = "tvSeasonAirDate")
  private Date airDate;

  @OneToMany(mappedBy = "season")
  private List<Episode> episodeList;
}
