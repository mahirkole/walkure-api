package com.mahirkole.walkure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "itemType", discriminatorType = DiscriminatorType.STRING)
public class Overview extends CoreModel {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String overview;

    @ManyToOne(fetch = FetchType.LAZY)
    private Language language;
}
