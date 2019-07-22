package com.asgardianwalkures.walkure.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "TVShow")
@Table(name = "tv_show")
public class TVShow extends CoreModel {

    @Id
    private Long id;
    private String name;
    private Person creator;
    private List<Genre> genreList;
    private List<Network> networkList;
    private Date firstAirDate;
    private List<Season> seasonList;
    private List<Episode> episodeList;
    private String country;
    private String language;
    private String overview;
    private Image poster;
    private List<Company> companyList;
    @URL
    private String homepage;
}
