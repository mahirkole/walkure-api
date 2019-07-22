package com.asgardianwalkures.walkure.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Company")
@Table(name = "company")
public class Company extends CoreModel{
    @Id
    private Long id;
    private String name;
    private String country;
    private Company parentCompany;
    private String description;
    @URL
    private String homepage;
    private Image logo;
}
