package com.kapish.thehindurest.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Cities {
    @Id
    private ObjectId _id;

    private String city;
    private List articleids;

    public Cities() {}

    public Cities(ObjectId _id, String city, List articleids) {
        this._id = _id;
        this.city = city;
        this.articleids = articleids;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List getArticleids() {
        return articleids;
    }

    public void setArticleids(List articleids) {
        this.articleids = articleids;
    }
}
