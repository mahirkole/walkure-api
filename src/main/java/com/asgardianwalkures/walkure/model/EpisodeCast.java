package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "EpisodeCast")
@DiscriminatorValue("episode")
@Data
public class EpisodeCast extends Casts {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "episode_id")
  private Episode episode;
}
