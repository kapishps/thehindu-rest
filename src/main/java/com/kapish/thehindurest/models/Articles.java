package com.kapish.thehindurest.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Articles {
    @Id
    private ObjectId _id;

    private String articleid;
    private String author;
    private String title;
    private String description;
    private String date;
    private List tags;
    private String city;
    private List categories;
    private String url;

    public Articles() {}

    public Articles(ObjectId _id, String articleid, String author, String title, String description, String date, List tags, String city, List categories, String url) {
        this._id = _id;
        this.articleid = articleid;
        this.author = author;
        this.title = title;
        this.description = description;
        this.date = date;
        this.tags = tags;
        this.city = city;
        this.categories = categories;
        this.url = url;
    }

    public ObjectId get_id() {
        return _id;
    }

    public String getArticleid() {
        return articleid;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public List getTags() {
        return tags;
    }

    public String getCity() {
        return city;
    }

    public List getCategories() {
        return categories;
    }

    public String getUrl() {
        return url;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTags(List tags) {
        this.tags = tags;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCategories(List categories) {
        this.categories = categories;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
