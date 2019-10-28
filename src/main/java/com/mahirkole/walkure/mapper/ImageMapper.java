package com.mahirkole.walkure.mapper;

import com.mahirkole.walkure.dto.ImageDto;
import com.mahirkole.walkure.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageMapper {

  ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

  ImageDto ImageToImageDto(Image image);
}
