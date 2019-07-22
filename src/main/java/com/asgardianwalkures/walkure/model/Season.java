package com.asgardianwalkures.walkure.model;

import com.asgardianwalkures.walkure.ImageIdConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Season")
@Table(name = "tv_season")
public class Season extends CoreModel{
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tvshow_id")
    private TVShow tvShow;
    private String name;
    private String overview;
    private Integer seasonNo;
    @Convert(converter = ImageIdConverter.class)
    private Image poster;
    private Date airDate;
    private List<Episode> episodeList;
}
