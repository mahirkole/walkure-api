package com.asgardianwalkures.walkure.repository;

import com.asgardianwalkures.walkure.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
  List<Company> findCompaniesByNameLike(String name);
}
