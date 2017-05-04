package io.realworld.conduit.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class Comment {
    private Integer id;
    private DateTime createdAt;
    private DateTime updatedAt;
    private String body;
    private Profile author;

    public Comment() {
    }

    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public DateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty
    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty
    public String getBody() {
        return body;
    }

    @JsonProperty
    public Profile getAuthor() {
        return author;
    }
}
