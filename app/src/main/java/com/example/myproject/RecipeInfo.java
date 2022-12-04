package com.example.myproject;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class RecipeInfo {

    private String name;
    private String category;
    private String[] step;

    public RecipeInfo() {
    }

    public RecipeInfo(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
