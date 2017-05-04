package io.realworld.conduit.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Tags {
    private List<String> tags;

    public Tags() {
    }

    public Tags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty
    public List<String> getTags() {
        return tags;
    }
}
