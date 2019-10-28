package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity(name = "TVShow")
@Table(name = "tv_show")
public class TVShow extends Title {

  @Id
  @GeneratedValue
  @Column(name = "tvShowId", updatable = false, nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "creator_id")
  private Person creator;

  @Column(name = "tvShowFirstAirDate")
  private Date firstAirDate;

  @Column(name = "tvShowCountry")
  private String country;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "tv_show_network",
      joinColumns = @JoinColumn(name = "tv_show_id"),
      inverseJoinColumns = @JoinColumn(name = "network_id"))
  private Set<Network> networkList = new HashSet<>();

  @OneToMany(mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Season> seasonList = new ArrayList<>();

  @OneToMany(mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Episode> episodeList = new ArrayList<>();
}
