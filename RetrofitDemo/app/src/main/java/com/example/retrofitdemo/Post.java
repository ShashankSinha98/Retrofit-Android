package com.example.retrofitdemo;

import com.google.gson.annotations.SerializedName;

// Represents a single JSON Object of response

// Using retrofit, we'll get post array from REST api and GSON converter will take care of converting these post json obj into post java obj
public class Post {

    private int userId;

    private int id;

    private String title;

    @SerializedName("body") // Actual name
    private String text; // Name that you want


    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
