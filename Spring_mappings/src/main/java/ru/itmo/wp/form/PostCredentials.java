package ru.itmo.wp.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PostCredentials {
    @NotNull
    @NotEmpty
    private String title;

    @NotEmpty
    @NotNull
    private String text;

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Size(min = 0, max = 300)
    @Pattern(regexp = "[[a-z][A-Z] ]+", message = "Expected Latin letters")
    private String tags;
}