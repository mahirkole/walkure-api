package com.asgardianwalkures.walkure.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Image")
@Table(name = "image")
public class Image extends CoreModel {

    @Id
    private Long id;
    private String url;
}
