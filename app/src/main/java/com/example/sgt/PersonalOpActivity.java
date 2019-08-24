package com.example.sgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PersonalOpActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    CheckBox whip_box;
    CheckBox drizzle_box;
    TextView shot_text;
    TextView syrub_text;
    TextView whip_text;
    TextView drizzle_text;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    int price_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_op);
        Intent intent = getIntent();
        price_size = intent.getExtras().getInt("price_total");
        shot_text = (TextView)findViewById(R.id.shot_price_text);
        syrub_text = (TextView)findViewById(R.id.syrub_price_text);
        whip_text = (TextView)findViewById(R.id.whip_price_text);
        drizzle_text = (TextView)findViewById(R.id.drizzle_price_text);

        whip_box = (CheckBox)findViewById(R.id.whip_checkBox) ;
        drizzle_box = (CheckBox)findViewById(R.id.drizzle_checkBox);

        arrayList = new ArrayList<>();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);

        spinner1 = (Spinner)findViewById(R.id.shot_spinner);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int shot_price;
                shot_price = 600 * Integer.parseInt(arrayList.get(i));
                shot_text.setText(String.valueOf(shot_price));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinner2 = (Spinner)findViewById(R.id.syrup_spinner);
        spinner2.setAdapter(arrayAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int syrub_price;
                syrub_price = 600 * Integer.parseInt(arrayList.get(i));
                syrub_text.setText(String.valueOf(syrub_price));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void back_to_menu(View v){
        finish();
    }

    public void whip_box_price(View v){
        if (whip_box.isChecked()){
            whip_text.setText(String.valueOf("600"));
        }else{
            whip_text.setText(String.valueOf("0"));
        }
    }

    public void drizzle_box_price(View v){
        if (drizzle_box.isChecked()){
            drizzle_text.setText(String.valueOf("600"));
        }else{
            drizzle_text.setText(String.valueOf("0"));
        }
    }

    public void plus_option (View v){
        int option_total_price = price_size + Integer.parseInt((String)whip_text.getText()) + Integer.parseInt((String)shot_text.getText()) + Integer.parseInt((String)syrub_text.getText()) + Integer.parseInt((String)drizzle_text.getText());
        Intent intent = new Intent(PersonalOpActivity.this, Main4Activity.class);
        intent.putExtra("option_price_total", option_total_price);
        startActivity(intent);
        finish();
    }
}
