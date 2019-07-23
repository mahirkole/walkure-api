package com.asgardianwalkures.walkure.model;

import com.asgardianwalkures.walkure.ImageIdConverter;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_company_id")
    @Column(name = "companyParent")
    private Company parentCompany;
  
    @OneToMany(mappedBy = "parentCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Company> childCompanyList;

    @Column(name = "companyDescription")
    private String description;

    @URL
    @Column(name = "companyHomePageUrl")
    private String homepage;

    @Convert(converter = ImageIdConverter.class)
    @Column(name = "companyLogo")
    private Image logo;

}
