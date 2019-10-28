package com.mahirkole.walkure.service;

import com.mahirkole.walkure.exception.NotFoundException;
import com.mahirkole.walkure.model.Company;
import com.mahirkole.walkure.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

  private final CompanyRepository companyRepository;

  @Autowired
  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  public Company getCompanyById(Long id) throws NotFoundException {
    return companyRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException(Company.class, id.toString()));
  }

  public void deleteCompanyById(Long id) throws NotFoundException {
    companyRepository.delete(getCompanyById(id));
  }

  public Company updateCompany(Company company) throws NotFoundException {
    Company existingCompany = getCompanyById(company.getId());

    if (company.getParentCompany() != null) {
      existingCompany.setParentCompany(getCompanyById(company.getParentCompany().getId()));
    }

    existingCompany.setName(company.getName());
    existingCompany.setLogo(company.getLogo());
    existingCompany.setCountry(company.getCountry());
    existingCompany.setDescription(company.getDescription());

    return companyRepository.save(existingCompany);
  }

  public Company createCompany(Company company) throws NotFoundException {
    Company parentCompany = null;

    if (company.getParentCompany() != null) {
      parentCompany = getCompanyById(company.getParentCompany().getId());
    }

    company.setParentCompany(parentCompany);
    return companyRepository.save(company);
  }

  public List<Company> getCompaniesByNameLike(String name) {
    return companyRepository.findCompaniesByNameLike(name);
  }
}
