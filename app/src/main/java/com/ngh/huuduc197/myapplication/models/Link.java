package com.ngh.huuduc197.myapplication.models;

/**
 * Created by nguyennhan on 5/13/18.
 */

public class Link {
    int _id;
    String title;
    String url;

    public Link(int _id, String title, String url) {
        this._id = _id;
        this.title = title;
        this.url = url;
    }

    public Link(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Link() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
