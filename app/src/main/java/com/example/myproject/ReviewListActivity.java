package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ReviewListActivity extends AppCompatActivity {

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        myAdapter = new MyAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnReviewClickListener(new OnReviewClickListener() {
            @Override
            public void onReviewClicked(Review review) {
                Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
                intent.putExtra("REVIEW", review);
                startActivity(intent);
            }
        });

        myAdapter.setOnCheckCountChangeListener(new OnCheckCountChangeListener() {
            @Override
            public void onCheckCountChanged(int count) {
                if(count == 0 || count == 1) invalidateOptionsMenu();
            }
        });
    }


}