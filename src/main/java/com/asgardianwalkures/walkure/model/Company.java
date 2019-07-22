package com.asgardianwalkures.walkure.model;

import com.asgardianwalkures.walkure.ImageIdConverter;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Company")
@Table(name = "company")
public class Company extends CoreModel{
    @Id
    private Long id;
    private String name;
    private String country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_company_id")
    private Company parentCompany;
    @OneToMany(mappedBy = "parentCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Company> childCompanyList;
    private String description;
    @URL
    private String homepage;
    @Convert(converter = ImageIdConverter.class)
    private Image logo;
}
