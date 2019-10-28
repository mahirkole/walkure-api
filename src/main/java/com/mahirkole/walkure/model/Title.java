package com.mahirkole.walkure.model;

import com.mahirkole.walkure.util.ImageIdConverter;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "Title")
@Table(name = "title")
@Inheritance(strategy = InheritanceType.JOINED)
// @SQLDelete(sql = "UPDATE title SET deleted_at = CURRENT_TIMESTAMP WHERE title_id = ? and
// updated_at = ?")
// @Loader(namedQuery = "findTitleById")
// @NamedQuery(name = "findTitleById", query = "SELECT t FROM Title t WHERE t.id = ?1 AND
// t.deletedAt IS NULL")
// @Where(clause = "deleted_at IS NULL")
public abstract class Title extends CoreModel {

  @Id
  @GeneratedValue
  @Column(name = "title_id", updatable = false, nullable = false)
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

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      fetch = FetchType.LAZY)
  @JoinTable(
      name = "title_genre",
      joinColumns = @JoinColumn(name = "title_id"),
      inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private Set<Genre> genres = new HashSet<>();

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      fetch = FetchType.LAZY)
  @JoinTable(
      name = "title_company",
      joinColumns = @JoinColumn(name = "title_id"),
      inverseJoinColumns = @JoinColumn(name = "company_id"))
  private Set<Company> companies = new HashSet<>();

  public void addCompany(Company company) {
    this.companies.add(company);
  }

  public void removeCompany(Company company) {
    this.companies.remove(company);
  }

  public void addGenre(Genre genre) {
    this.genres.add(genre);
  }

  public void removeGenre(Genre genre) {
    this.genres.remove(genre);
  }
}
