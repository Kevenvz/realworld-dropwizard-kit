package io.realworld.conduit.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class Article {
    private String slug;
    private String title;
    private String description;
    private String body;
    private DateTime createdAt;
    private DateTime updatedAt;
    private Boolean favorited;
    private Integer favoritesCount;
    private Profile author;

    public Article() {
    }

    public Article(String slug, String title, String description, String body, DateTime createdAt, DateTime updatedAt, Boolean favorited, Integer favoritesCount, Profile author) {
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.favorited = favorited;
        this.favoritesCount = favoritesCount;
        this.author = author;
    }

    @JsonProperty
    public String getSlug() {
        return slug;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getBody() {
        return body;
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
    public Boolean getFavorited() {
        return favorited;
    }

    @JsonProperty
    public Integer getFavoritesCount() {
        return favoritesCount;
    }

    @JsonProperty
    public Profile getAuthor() {
        return author;
    }
}
