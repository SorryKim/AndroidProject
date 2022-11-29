package com.example.myproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataBase extends AppCompatActivity {

    private EditText edit_name, edit_category;
    private Button button;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecipeInfo recipeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db);

        edit_name = findViewById(R.id.recipeName);
        edit_category = findViewById(R.id.recipeCategory);
        button = findViewById(R.id.recipeButton);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("recipe");

        recipeInfo = new RecipeInfo();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edit_name.getText().toString();
                String category = edit_category.getText().toString();

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(category)){
                    Toast.makeText(DataBase.this, "Please add some data", Toast.LENGTH_SHORT).show();
                }
                else{
                    addDatatoFirebase(name,category);
                }
            }
        });

    }

    private void addDatatoFirebase(String name, String category){

        recipeInfo.setName(name);
        recipeInfo.setCategory(category);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                databaseReference.setValue(name);

                Toast.makeText(DataBase.this, "data added!" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DataBase.this, "Fail to add data" + databaseError, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
