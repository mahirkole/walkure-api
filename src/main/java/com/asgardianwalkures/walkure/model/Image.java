package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Image")
@Table(name = "image")
public class Image extends CoreModel {

    @Id
    @Column(name = "imageId")
    private Long id;

    @Column(name = "imageUrl")
    private String url;

}
