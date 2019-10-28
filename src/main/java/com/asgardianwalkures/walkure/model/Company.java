package com.asgardianwalkures.walkure.model;

import com.asgardianwalkures.walkure.util.ImageIdConverter;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Company")
@Table(name = "company")
public class Company extends CoreModel {

  @Id
  @Column(name = "company_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "companyName")
  private String name;

  @Column(name = "companyCountry")
  private String country;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "parent_company_id")
  private Company parentCompany;

  @OneToMany(mappedBy = "parentCompany", orphanRemoval = true)
  private List<Company> childCompanyList = new ArrayList<>();

  @Column(name = "companyDescription")
  private String description;

  @URL
  @Column(name = "companyHomePageUrl")
  private String homepage;

  @Convert(converter = ImageIdConverter.class)
  @Column(name = "companyLogo")
  private Image logo;

  public Company() {}

  public Company(Long id) {
    this.id = id;
  }

  public void addChildCompany(Company company) {
    this.childCompanyList.add(company);
  }

  public void removeChildCompany(Company company) {
    this.childCompanyList.remove(company);
  }
}
