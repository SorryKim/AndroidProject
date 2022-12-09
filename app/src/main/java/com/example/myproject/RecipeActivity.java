package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivity extends AppCompatActivity{

    Button btnYoutube, btnReview, btnCheck;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);
        textview = findViewById(R.id.recipeName);
        btnYoutube = findViewById(R.id.gotoYoutubeButton);
        btnReview = findViewById(R.id.gotoReview);
        Intent intent = getIntent();
        String str = intent.getStringExtra("selectedFood");
        btnClick(str);
        textview.setText(str);
    }


    // 버튼 클릭처리리
   private void btnClick(String str){

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), YoutubeActivity.class);
                in.putExtra("selectedFood", str);
                startActivity(in);
            }
        });

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MemoListActivity.class);
                in.putExtra("selectedFood", str);
                startActivity(in);
            }
        });


    }

}
