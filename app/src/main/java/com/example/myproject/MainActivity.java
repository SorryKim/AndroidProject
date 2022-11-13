package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myproject.MyAdapter;

public class MainActivity extends AppCompatActivity implements MyAdapter.ItemClickListener{

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, Youtube.class));
        String[] data = new String[100];
        for(int i = 1; i <= 100; i++){
            data[i - 1] = "freind #" + i;
        }

        RecyclerView recyclerView = findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view,int position){
        Log.i("TAG", "ITEM: " + adapter.getItem(position) + "number: " + position);
    }
}