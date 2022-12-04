package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addreview);
        EditText editText= (EditText) findViewById(R.id.editReview);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);

        Review review = (Review) getIntent().getSerializableExtra("REVIEW");
        if (review != null) {
            editText.setText(review.getReview());
        }

        Button button = (Button) findViewById(R.id.reviewSubmitBtn);
        Button button1 = (Button)findViewById(R.id.reviewCancelBtn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strReview = editText.getText().toString();
                if (TextUtils.isEmpty(strReview)) {
                    editText.setError("NO EMPTY!");
                    return;
                }
                String score = "SCORE: " +  Float.toString(ratingBar.getRating());
                Review review = new Review(strReview, score);
                Intent intent = new Intent();
                intent.putExtra("REVIEW", review);
                finish();
            }
        });


    }
}