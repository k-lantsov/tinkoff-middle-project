package com.company.personservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Data
@MappedSuperclass
public class ParentEntity {

    @Id
    private long id;

    @Column(name = "uuid_d")
    private UUID uuid = UUID.randomUUID();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentEntity that = (ParentEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
