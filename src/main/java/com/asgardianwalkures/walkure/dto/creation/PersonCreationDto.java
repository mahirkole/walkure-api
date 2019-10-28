package com.asgardianwalkures.walkure.dto.creation;

import com.asgardianwalkures.walkure.dto.CoreDto;
import lombok.Data;

@Data
public class PersonCreationDto extends CoreDto {

  private String name;
  private String birthday;
  private String gender;
  private String bio;
  private String birthPlace;
  private String homepage;
  private String imageUrl;
}
