package com.ngh.huuduc197.myapplication.models;

/**
 * Created by nguyennhan on 5/13/18.
 */

public class Link {
    String _id;
    String url;

    public Link(String _id, String url) {
        this._id = _id;
        this.url = url;
    }

    public Link() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
