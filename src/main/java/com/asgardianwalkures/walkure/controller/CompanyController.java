package com.asgardianwalkures.walkure.controller;

import com.asgardianwalkures.walkure.annotation.MapperAspect;
import com.asgardianwalkures.walkure.dto.creation.CompanyCreationDto;
import com.asgardianwalkures.walkure.exception.NotFoundException;
import com.asgardianwalkures.walkure.mapper.CompanyMapper;
import com.asgardianwalkures.walkure.model.Company;
import com.asgardianwalkures.walkure.service.CompanyService;
import com.asgardianwalkures.walkure.util.EndpointConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndpointConstants.COMPANY)
public class CompanyController {
  private final CompanyService companyService;

  @Autowired
  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @GetMapping("/")
  @MapperAspect
  public ResponseEntity<List<Company>> getCompanies(@RequestParam(required = false) String name) {
    if (name != null) {
      return new ResponseEntity<>(companyService.getCompaniesByNameLike(name), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }
  }

  @GetMapping("/{id}")
  @MapperAspect
  public ResponseEntity<Company> getCompanyById(@PathVariable Long id) throws NotFoundException {
    return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.FOUND);
  }

  @PostMapping("/")
  @MapperAspect
  public ResponseEntity<Company> createCompany(@RequestBody CompanyCreationDto companyCreationDto)
      throws NotFoundException {
    Company company = CompanyMapper.INSTANCE.toModel(companyCreationDto);

    if (companyCreationDto.getParentId() != null) {
      company.setParentCompany(new Company(companyCreationDto.getParentId()));
    }

    return new ResponseEntity<>(companyService.createCompany(company), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @MapperAspect
  public ResponseEntity<Company> updateCompany(
      @PathVariable Long id, @RequestBody CompanyCreationDto companyCreationDto)
      throws NotFoundException {
    Company company = CompanyMapper.INSTANCE.toModel(companyCreationDto);
    company.setId(id);

    if (companyCreationDto.getParentId() != null) {
      company.setParentCompany(new Company(companyCreationDto.getParentId()));
    }

    return new ResponseEntity<>(companyService.updateCompany(company), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteCompany(@PathVariable Long id) throws NotFoundException {
    companyService.deleteCompanyById(id);
    return new ResponseEntity(null, HttpStatus.NO_CONTENT);
  }
}
