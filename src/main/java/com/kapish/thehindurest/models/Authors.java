package com.kapish.thehindurest.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Authors {
    @Id
    private ObjectId _id;

    private String author;
    private List articleids;

    public Authors() {}

    public Authors(ObjectId _id, String author, List articleids) {
        this._id = _id;
        this.author = author;
        this.articleids = articleids;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List getArticleids() {
        return articleids;
    }

    public void setArticleids(List articleids) {
        this.articleids = articleids;
    }
}
