package com.example.myproject;

import java.io.Serializable;

public class Review implements Serializable {

    String review;
    String rating;

    public Review(){}
    public Review(String review, String rating){
        this.review = review;
        this.rating = rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }
    public String getRating() {
        return rating;
    }

}
