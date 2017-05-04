package io.realworld.conduit.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;

    public User() {
    }

    public User(String email, String token, String username, String bio, String image) {
        this.email = email;
        this.token = token;
        this.username = username;
        this.bio = bio;
        this.image = image;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public String getToken() {
        return token;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }

    @JsonProperty
    public String getBio() {
        return bio;
    }

    @JsonProperty
    public String getImage() {
        return image;
    }
}
