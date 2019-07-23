package com.asgardianwalkures.walkure.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Network")
@Table(name = "network")
public class Network extends CoreModel {

    @Id
    @Column(name = "network_id")
    private Long id;

    @Column(name = "network_name")
    private String name;

    private String county;

    @URL
    private String homepage;

    private String hqAddress;
}
