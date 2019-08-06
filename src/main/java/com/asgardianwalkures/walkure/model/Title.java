package com.asgardianwalkures.walkure.model;

import com.asgardianwalkures.walkure.ImageIdConverter;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "Title")
@Table(name = "title")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Title extends CoreModel {

    @Id
    @Column(name = "title_id")
    private Long id;

    @Column(name = "title_name")
    private String name;

    @URL
    @Column(name = "title_homepage")
    private String homepage;

    @Convert(converter = ImageIdConverter.class)
    @Column(name = "title_poster_id")
    private Image poster;

    @Lob
    @Column(name = "title_overview")
    private String overview;

    @Column(name = "title_language")
    private String language;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "title_genre",
            joinColumns = @JoinColumn(name = "title_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "title_company",
            joinColumns = @JoinColumn(name = "title_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> companies = new HashSet<>();
}
