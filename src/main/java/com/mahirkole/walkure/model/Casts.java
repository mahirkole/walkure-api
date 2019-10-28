package com.mahirkole.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Casts")
@Table(name = "casts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Casts extends CoreModel {

  @Id
  @Column(name = "casts_id")
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  private Person person;

  @Column(name = "castsCharacter")
  private String character;

  @Column(name = "castsOrder")
  private Integer order;
}
