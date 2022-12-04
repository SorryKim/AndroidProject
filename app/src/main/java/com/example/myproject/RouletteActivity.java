package com.example.myproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteActivity extends AppCompatActivity {

    // 변수 선언
    List<WheelItem> wheelItems;
    LuckyWheel luckyWheel;
    String point, selectedFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roulette);

        // 변수 담기
        luckyWheel = findViewById(R.id.Wheel);

        // 점수판 데이터 생성
        Intent intent = getIntent();
        int index = intent.getIntExtra("categoryId",0);
        generateWheelItems(index);

        // 점수판 타겟 정해지면 이벤트 발생
        luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {

                // 아이템 변수에 담기
                WheelItem wheelItem = wheelItems.get(Integer.parseInt(point) - 1);

                // 아이템 텍스트 변수에 담기
                selectedFood = wheelItem.text;

                // 알람상자로 확인
                open();
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
    public void generateWheelItems(int index){

        wheelItems = new ArrayList<>();
        String[] foods;
        String[] colors = { "#F44336", "#E91E63", "#9C26B0", "#3F50B0", "#1E84E2", "#009888"};
        switch (index){
            // Maindish
            case 0:
                foods = new String[]{getResources().getString(R.string.KimchiFriedrice), getResources().getString(R.string.Tteokbokki), getResources().getString(R.string.Tteokbokki),
                        getResources().getString(R.string.Bulgogi), getResources().getString(R.string.Chapaguri), getResources().getString(R.string.StirfriedSundae)};
                break;
            // Soup
            case 1:
                foods = new String[]{"김치찌개", "감자탕", "닭개장", "갈비탕", "북엇국", "된장찌개"};
                break;
            // Westernfood
            case 2:
                foods = new String[]{"돈까스", "비빔밥", "김치볶음밥", "갈비탕", "떡볶이", "불고기"};
                break;
            default:
                foods = new String[]{"김치볶음밥", "떡볶이", "제육볶음", "불고기", "짜파구리", "순대볶음"};
        }

        Drawable d = getResources().getDrawable(R.drawable.ic_baseline_thumb_up_alt_24, null);
        Bitmap bitmap = drawbleToBitmap(d);

        for(int i = 0; i < 6; i++){
            wheelItems.add(new WheelItem(Color.parseColor(colors[i]), bitmap, foods[i]));
        }

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

    // 알람상자 처리
    private void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(getResources().getString(R.string.alert));
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent in = new Intent(getApplicationContext(), RecipeActivity.class);
                in.putExtra("selectedFood", selectedFood);
                startActivity(in);
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}