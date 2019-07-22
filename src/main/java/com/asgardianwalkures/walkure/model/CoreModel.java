package com.asgardianwalkures.walkure.model;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class CoreModel {

    private UUID uuid;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

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
