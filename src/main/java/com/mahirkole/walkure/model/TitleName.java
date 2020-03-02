package com.mahirkole.walkure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue(value = "title")
public class TitleName extends ItemName {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Title title;
}
