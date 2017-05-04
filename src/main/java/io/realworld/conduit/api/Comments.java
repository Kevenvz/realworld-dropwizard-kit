package io.realworld.conduit.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Comments {
    private List<Comment> comments;

    public Comments() {
    }

    public Comments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonProperty
    public List<Comment> getComments() {
        return comments;
    }
}
