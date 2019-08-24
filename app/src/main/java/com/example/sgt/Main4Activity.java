package com.example.sgt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    String data[] = {"Tall","Grande","Venti"};
    TextView cup_size_text;
    int price;
    TextView price_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        price = intent.getExtras().getInt("price_total");

        price += intent.getExtras().getInt("option_price_total");

        price_text = findViewById(R.id.total_price);
        cup_size_text = findViewById(R.id.cup_size);
        price_text.setText(String.valueOf(price));
    }

    public void select_size(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
        builder.setTitle("사이즈를 선택해주세요.");
        builder.setSingleChoiceItems(data,0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int price_size = price;
                cup_size_text.setText(data[i]);
                if(i == 1){
                    price_size += 600;
                }else if(i == 2){
                    price_size += 1200;
                }
                price_text.setText(String.valueOf(price_size));
            }
        });


        builder.setPositiveButton("확인",null);
        builder.setNegativeButton("취소",null);
        builder.create().show();
    }
    public void back_to_menu(View v){
        Intent intent = new Intent(Main4Activity.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }

    public void go_to_personal_op(View v){
        Intent intent = new Intent(Main4Activity.this,PersonalOpActivity.class);
        intent.putExtra("price_total", Integer.parseInt((String)price_text.getText()));

        startActivity(intent);
    }
}
