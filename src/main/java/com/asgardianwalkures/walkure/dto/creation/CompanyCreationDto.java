package com.asgardianwalkures.walkure.dto.creation;

import com.asgardianwalkures.walkure.dto.CoreDto;
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
