package com.topica.itlab.artandculture.model;

public class Post {
    private String id;
    private String pathImage;
    private String category;
    private String Title;
    private String Date;

    public Post(String id,String pathImage, String category, String title, String date) {
        this.id = id;
        this.pathImage = pathImage;
        this.category = category;
        Title = title;
        Date = date;
    }

    public String getId() {
        return id;
    }

    public String getPathImage() {
        return pathImage;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return Title;
    }

    public String getDate() {
        return Date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDate(String date) {
        Date = date;
    }
}
