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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private Person creator;
  
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "genre_id")
    private List<Genre> genreList;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "network_id")
    private List<Network> networkList;

    @OneToMany(mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasonList;
    
    @OneToMany(mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = true)
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
    @Column(name = "tvShowPoster")
    private Image poster;
  
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private List<Company> companyList;
  
    @URL
    @Column(name = "tvShowHomePageUrl")
    private String homepage;
}
