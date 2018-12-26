package com.kapish.thehindurest.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Dates {
    @Id
    private ObjectId _id;

    private String date;
    private List articleids;

    public Dates() {}

    public Dates(ObjectId _id, String date, List articleids) {
        this._id = _id;
        this.date = date;
        this.articleids = articleids;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List getArticleids() {
        return articleids;
    }

    public void setArticleids(List articleids) {
        this.articleids = articleids;
    }
}
