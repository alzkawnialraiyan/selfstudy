package com.example.selfstudy;

import android.widget.ImageView;
import android.widget.Toolbar;

public class post {
    private String toolbar;
    private String post;
    private String fav;
    private String message;
    private String send;
    private String bookmark;
    private String comments;



    public post(String toolbar, String post, String fav, String message, String send, String bookmark, String comments) {
        this.toolbar = toolbar;
        this.post = post;
        this.fav = fav;
        this.message = message;
        this.send = send;
        this.bookmark = bookmark;
        this.comments = comments;
    }

    public String getToolbar(){
        return toolbar;
    }
    public String getPost(){
        return post;
    }
    public String getFav(){
        return fav;
    }
    public String getMessage(){
        return message;
    }
    public String getSend(){
        return send;
    }
    public String getBookmark(){
        return bookmark;
    }
    public String getComments(){
        return comments;
    }
}

