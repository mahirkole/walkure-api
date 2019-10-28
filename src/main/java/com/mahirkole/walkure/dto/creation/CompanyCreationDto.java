package com.mahirkole.walkure.dto.creation;

import com.mahirkole.walkure.dto.CoreDto;
import lombok.Data;

@Data
public class CompanyCreationDto extends CoreDto {
  private String name;
  private String country;
  private Long parentId;
  private String description;
  private String homepage;
  private Long imageId;
}
