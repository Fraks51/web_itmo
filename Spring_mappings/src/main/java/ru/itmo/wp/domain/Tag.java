package ru.itmo.wp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    /** @noinspection unused*/
    public Tag() {
    }

    public Tag(@NotNull String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
