package com.asgardianwalkures.walkure.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class CoreModel {

    private UUID uuid;

    @CreatedDate
    @Column(name = "createdDate")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    @Version
    private Date lastModifiedDate;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

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
