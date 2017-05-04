package io.realworld.conduit.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {
    private String username;
    private String bio;
    private String image;
    private Boolean following;

    public Profile() {
    }

    public Profile(String username, String bio, String image, Boolean following) {
        this.username = username;
        this.bio = bio;
        this.image = image;
        this.following = following;
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

    @JsonProperty
    public Boolean getFollowing() {
        return following;
    }
}
