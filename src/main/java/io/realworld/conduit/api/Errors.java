package io.realworld.conduit.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Errors {
    private List<String> body;

    public Errors() {
    }

    public Errors(List<String> body) {
        this.body = body;
    }

    @JsonProperty
    public List<String> getBody() {
        return body;
    }
}
