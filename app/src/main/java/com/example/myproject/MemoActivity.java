package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import java.util.Date;

public class MemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        RatingBar ratingBar = findViewById(R.id.activity_ratingBar);
        EditText editText_content = findViewById(R.id.editText_content);
        Memo memo = (Memo) getIntent().getSerializableExtra("MEMO");
        Integer index = (Integer) getIntent().getSerializableExtra("index");
        if (memo != null) {
            editText_content.setText(memo.getContent());
        }
        Button button = findViewById(R.id.btnSave);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float score = ratingBar.getRating();
                String content = editText_content.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    editText_content.setError("내용을 입력하세요");
                    return;
                }
                Memo memo = new Memo(score, content, new Date());
                Intent intent = new Intent();
                intent.putExtra("MEMO", memo);
                intent.putExtra("index", index);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        button.setOnClickListener(listener);
    }
}