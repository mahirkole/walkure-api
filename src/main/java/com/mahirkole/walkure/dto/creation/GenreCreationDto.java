package com.mahirkole.walkure.dto.creation;

import com.mahirkole.walkure.dto.CoreDto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class GenreCreationDto extends CoreDto {

  @NotEmpty @NotNull String name;
}
