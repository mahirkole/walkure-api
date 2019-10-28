package com.asgardianwalkures.walkure.mapper;

import com.asgardianwalkures.walkure.dto.ImageDto;
import com.asgardianwalkures.walkure.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageMapper {

  ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

  ImageDto ImageToImageDto(Image image);
}
