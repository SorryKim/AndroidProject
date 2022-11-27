package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myproject.MyAdapter;

public class CategoryActivity extends AppCompatActivity {

    Button btn_maindish;
    Button btn_soup;
    Button btn_western;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        // 버튼 변수설정
        btn_maindish = (Button)findViewById(R.id.btn_maindish);
        btn_soup = (Button)findViewById(R.id.btn_soup);
        btn_western = (Button)findViewById(R.id.btn_western);
        Click();
    }

    private void Click(){

        // 메인 디쉬를 클릭했을 경우
        btn_maindish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), RecipeActivity.class);
                in.putExtra("categoryId",0);
                startActivity(in);
            }
        });

        // 찌개를 클릭했을 경우
        btn_soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), Youtube.class);
                in.putExtra("categoryId",1);
                startActivity(in);
            }
        });

        // 양식을 클릭했을 경우
        btn_western.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), Roulette.class);
                in.putExtra("categoryId",2);
                startActivity(in);
            }
        });


    }

}