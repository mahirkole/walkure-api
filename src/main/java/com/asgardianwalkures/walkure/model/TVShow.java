package com.asgardianwalkures.walkure.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "TVShow")
@Table(name = "tv_show")
public class TVShow extends CoreModel {

    @Id
    @Column(name = "tvShowId")
    private Long id;

    @Column(name = "tvShowName")
    private String name;

    @Column(name = "tvShowFirstAirDate")
    private Date firstAirDate;

    @Column(name = "tvShowCountry")
    private String country;

    @Column(name = "tvShowLanguage")
    private String language;

    @Lob
    @Column(name = "tvShowOverview")
    private String overview;

    private Person creator;

    private Image poster;

    @URL
    @Column(name = "tvShowHomePageUrl")
    private String homepage;

    @ManyToMany
    private List<Genre> genreList;

    @OneToMany(mappedBy = "tvShow")
    private List<Season> seasonList;

    @OneToMany(mappedBy = "tvShow")
    private List<Episode> episodeList;

    private List<Company> companyList;

    private List<Network> networkList;
}
