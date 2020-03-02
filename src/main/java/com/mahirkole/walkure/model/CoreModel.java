package com.mahirkole.walkure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Embeddable
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class CoreModel {

    private UUID uuid = UUID.randomUUID();

    @CreatedDate
    @Column(name = "createdAt")
    private Date createdAt = new Date();

    @LastModifiedDate
    @Column(name = "updatedAt")
    @Version
    private Date updatedAt;

    @Column(name = "deletedAt", nullable = true)
    private Date deletedAt = null;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof CoreModel)) {
            return false;
        } else {
            return (this.uuid != null) && this.uuid.equals(((CoreModel) o).uuid);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uuid);
    }
}
