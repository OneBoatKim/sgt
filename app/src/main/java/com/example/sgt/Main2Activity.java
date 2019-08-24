package com.example.sgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void back_to_menu(View v){
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setting_menu(View v){
        Intent intent = new Intent(Main2Activity.this,Main4Activity.class);
        intent.putExtra("price_total", 6100);
        startActivity(intent);
    }
}
