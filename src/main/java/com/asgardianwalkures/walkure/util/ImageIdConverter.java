package com.asgardianwalkures.walkure.util;

import com.asgardianwalkures.walkure.model.Image;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ImageIdConverter implements AttributeConverter<Image, Long> {

  @Override
  public Long convertToDatabaseColumn(Image image) {
    if (image == null) return null;
    return image.getId();
  }

  @Override
  public Image convertToEntityAttribute(Long imageId) {
    Image image = new Image();
    image.setId(imageId);
    return image;
  }
}
