package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Season")
@Table(name = "tv_season")
public class Season extends CoreModel{
    @Id
    private Long id;
    private Long tvShowId;
    private String name;
    private String overview;
    private Integer seasonNo;
    private Image poster;
    private Date airDate;
    private List<Episode> episodeList;
}
