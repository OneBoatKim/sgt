package com.example.sgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void back_to_menu(View v){
        Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
