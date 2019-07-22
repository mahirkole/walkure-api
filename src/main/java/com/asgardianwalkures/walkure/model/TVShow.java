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
    private Long id;
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
    private String country;
    private String language;
    private String overview;
    @Convert(converter = ImageIdConverter.class)
    private Image poster;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private List<Company> companyList;
    @URL
    private String homepage;
}
