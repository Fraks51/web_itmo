package ru.itmo.wp.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        indexes = @Index(columnList = "creationTime"),
        uniqueConstraints = @UniqueConstraint(columnNames = "login")
)
public class User {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @NotEmpty
    private String login;

    @CreationTimestamp
    private Date creationTime;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    private boolean disabled;

    public User() {
        disabled = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
