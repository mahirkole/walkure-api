package com.mahirkole.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "EpisodeCrew")
@DiscriminatorValue("episode")
@Data
public class EpisodeCrew extends Crew {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "episode_id")
  private Episode episode;
}
