package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class YoutubeActivity extends AppCompatActivity {

    private Button btn;
    private LinearLayout layout;
    private String selectedFood;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube);
        layout = findViewById(R.id.youtubeLayout);
        Intent intent = getIntent();
        selectedFood = intent.getStringExtra("selectedFood");

        // URL설정
        setURL(selectedFood);

        // youtubeplayer
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        YouTubePlayerView youTubePlayerView = new YouTubePlayerView(YoutubeActivity.this);
        youTubePlayerView.setLayoutParams(params);
        layout.addView(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(url, 0);
            }
        });

        // cancel button
        btn = findViewById(R.id.youtubeBackButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void setURL(String name){

        if(name.equals(getResources().getString(R.string.KimchiFriedrice)))
            url = "xKIIKELDjiU";

        if(name.equals(getResources().getString(R.string.Bulgogi)))
            url = "OvjigFXVZr8";

        if(name.equals(getResources().getString(R.string.StirfriedSundae)))
            url = "ukNoJQDiNjE";

        if(name.equals(getResources().getString(R.string.StirFriedPork)))
            url = "bFuz6YgFmyU";

        if(name.equals(getResources().getString(R.string.Tteokbokki)))
            url = "Y8OFkrLW-ak";

        if(name.equals(getResources().getString(R.string.Jjageuli)))
            url = "6AotE8eVxa8";


    }


}

