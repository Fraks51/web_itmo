package ru.itmo.wp.form;

import ru.itmo.wp.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostCredentials {
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 60)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 65000)
    @Lob
    private String text;
}
