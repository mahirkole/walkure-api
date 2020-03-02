package com.mahirkole.walkure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Video extends CoreModel {

    @Id
    @GeneratedValue
    private Long id;

    private String path;

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;
}
