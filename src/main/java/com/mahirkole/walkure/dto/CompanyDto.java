package com.mahirkole.walkure.dto;

import lombok.Data;

@Data
public class CompanyDto {

  private Long id;
  private String name;
  private String country;
  private CompanyDto parent;
  private String description;
  private String homepage;
  private ImageDto logo;
}
