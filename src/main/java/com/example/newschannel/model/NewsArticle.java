package com.example.newschannel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class NewsArticle {
    private String author;
    private String title;
    private String description;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    @JsonProperty("source")
    private Source source;

    // Getters and Setters (omitted for brevity)

    public static class Source {
        private String id;
        private String name;

        // Getters and Setters (omitted for brevity)
    }
}
