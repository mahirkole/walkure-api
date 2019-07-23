package com.asgardianwalkures.walkure.model;

import com.asgardianwalkures.walkure.ImageIdConverter;
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

    private Person creator;
  
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "genre_id")
    private List<Genre> genreList;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "network_id")
    private List<Network> networkList;
    
    private Date firstAirDate;
    
    @OneToMany(mappedBy = "Season", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasonList;
    
    @OneToMany(mappedBy = "Episode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodeList;

    @Column(name = "tvShowFirstAirDate")
    private Date firstAirDate;

    @Column(name = "tvShowCountry")
    private String country;

    @Column(name = "tvShowLanguage")
    private String language;

    @Lob
    @Column(name = "tvShowOverview")
    private String overview;
  
    @Convert(converter = ImageIdConverter.class)
    private Image poster;
  
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private List<Company> companyList;
  
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
