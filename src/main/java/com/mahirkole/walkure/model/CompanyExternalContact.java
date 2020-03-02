package com.mahirkole.walkure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue(value = "company")
public class CompanyExternalContact extends ExternalContact {

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Company company;
}
