package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeActivity extends AppCompatActivity implements MyAdapter.ItemClickListener{

    MyAdapter adapter;
    Button btnYoutube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        btnYoutube = findViewById(R.id.gotoYoutubeButton);

        Intent intent = getIntent();
        String str = intent.getStringExtra("selectedFood");
        String[] data = new String[100];
        for(int i = 1; i <= 100; i++){
            data[i - 1] = str + i;
        }

        RecyclerView recyclerView = findViewById(R.id.rview);
        int columns = 3;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), YoutubeActivity.class);
                in.putExtra("selectedFood", str);
                startActivity(in);
            }
        });
    }

    @Override
    public void onItemClick(View view, int position){
        Log.i("TAG", "ITEM: " + adapter.getItem(position) + "number: " + position);
    }

}
