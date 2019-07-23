package com.asgardianwalkures.walkure.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Company")
@Table(name = "company")
public class Company extends CoreModel {

    @Id
    @Column(name = "companyId")
    private Long id;

    @Column(name = "companyName")
    private String name;

    @Column(name = "companyCountry")
    private String country;

    @Column(name = "companyParent")
    private Company parentCompany;

    @Column(name = "companyDescription")
    private String description;

    @URL
    @Column(name = "companyHomePageUrl")
    private String homepage;

    @Column(name = "companyLogo")
    private Image logo;

}
