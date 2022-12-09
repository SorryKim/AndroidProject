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

        if(name.equals(getResources().getString(R.string.Kimchistew)))
            url = "siDln_TfVm8";

        if(name.equals(getResources().getString(R.string.Gamjatang)))
            url = "Wn3p6bKxSXU";

        if(name.equals(getResources().getString(R.string.Galbitang)))
            url = "Ot8rOHITb64";

        if(name.equals(getResources().getString(R.string.SoybeanPasteStew)))
            url = "n8lMW8OFu_o";

        if(name.equals(getResources().getString(R.string.BudaeJjigae)))
            url = "Ore5b-hcAK4";

        if(name.equals(getResources().getString(R.string.EggSoup)))
            url = "mP8kb2BUK9s";

        if(name.equals(getResources().getString(R.string.PorkCutlet)))
            url = "Ygrzqtfb178";

        if(name.equals(getResources().getString(R.string.EggCheeseToast)))
            url = "qw7letv1DJw";

        if(name.equals(getResources().getString(R.string.CreamPasta)))
            url = "83oVI8nhmAA";

        if(name.equals(getResources().getString(R.string.Hamburger)))
            url = "NAVuMnDxYEY";

        if(name.equals(getResources().getString(R.string.Steak)))
            url = "64LaC4xb6Zg";

        if(name.equals(getResources().getString(R.string.Pizza)))
            url = "5Ay74by0pHc";


    }


}

