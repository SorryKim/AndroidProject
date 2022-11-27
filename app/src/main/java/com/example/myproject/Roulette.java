package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roulette extends AppCompatActivity {

    // 변수 선언
    List<WheelItem> wheelItems;
    LuckyWheel luckyWheel;
    String point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roulette);

        // 변수 담기
        luckyWheel = findViewById(R.id.Wheel);

        // 점수판 데이터 생성
        generateWheelItems();

        // 점수판 타겟 정해지면 이벤트 발생
        luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {

                // 아이템 변수에 담기
                WheelItem wheelItem = wheelItems.get(Integer.parseInt(point) - 1);

                // 아이템 텍스트 변수에 담기
                String food = wheelItem.text;

                // 메시지
                Toast.makeText(Roulette.this, food, Toast.LENGTH_SHORT).show();

            }
        });

        // 시작버튼
        Button start =findViewById(R.id.Button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                point = String.valueOf(random.nextInt(6) + 1);
                luckyWheel.rotateWheelTo(Integer.parseInt(point));
            }
        });
    }

    // 데이터 담기
    public void generateWheelItems(){

        wheelItems = new ArrayList<>();

        Drawable d = getResources().getDrawable(R.drawable.ic_money, null);
        Bitmap bitmap = drawbleToBitmap(d);

        wheelItems.add(new WheelItem(Color.parseColor("#F44336"), bitmap, "김치찌개"));
        wheelItems.add(new WheelItem(Color.parseColor("#E91E63"), bitmap, "비빔밥"));
        wheelItems.add(new WheelItem(Color.parseColor("#9C26B0"), bitmap, "김치볶음밥"));
        wheelItems.add(new WheelItem(Color.parseColor("#3F50B0"), bitmap, "갈비탕"));
        wheelItems.add(new WheelItem(Color.parseColor("#1E84E2"), bitmap, "떡볶이"));
        wheelItems.add(new WheelItem(Color.parseColor("#009888"), bitmap, "불고기"));

        luckyWheel.addWheelItems(wheelItems);

    }

    // drawble -> bitmap
    public static Bitmap drawbleToBitmap(Drawable drawable){

        if(drawable instanceof BitmapDrawable){
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicWidth(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }


}