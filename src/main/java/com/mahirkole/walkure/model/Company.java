package com.mahirkole.walkure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Company extends CoreModel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Company parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private Set<Company> childList = new HashSet<>();

    @Lob
    private String description;

    @OneToMany(mappedBy = "company")
    private Set<CompanyExternalContact> homepage;

    @OneToOne
    @JoinColumn(name = "logo_image_id")
    private Image logo;
}
