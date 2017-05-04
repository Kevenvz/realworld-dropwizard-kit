package io.realworld.conduit.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Articles {
    private List<Article> articles;
    private Integer articlesCount;

    public Articles() {
    }

    @JsonProperty
    public List<Article> getArticles() {
        return articles;
    }

    @JsonProperty
    public Integer getArticlesCount() {
        return articlesCount;
    }
}
