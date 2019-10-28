package com.asgardianwalkures.walkure.dto;

import lombok.Data;

@Data
public class PersonDto extends CoreDto {
  private Long id;
  private String name;
  private String birthday;
  private String gender;
  private String bio;
  private String birthPlace;
  private String homepage;
  private String imageUrl;
}
