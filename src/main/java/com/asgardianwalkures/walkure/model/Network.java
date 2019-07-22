package com.asgardianwalkures.walkure.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Network")
@Table(name = "network")
public class Network extends CoreModel {

    @Id
    private Long id;
    private String name;
    private String county;
    @URL
    private String homepage;
    private String hqAddress;
}
