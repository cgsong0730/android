package com.example.pro2;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   RadioButton radio1;
   RadioButton radio2;
   TextView unit;
   EditText input1;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       radio1 = findViewById(R.id.radio1);
       radio2 = findViewById(R.id.radio2);
       unit = findViewById(R.id.unit);
       input1 = findViewById(R.id.input1);

       radio1.setChecked(true);
   }

   public void onButtonClick(View view) {

       try {
           Float temp1 = Float.parseFloat(input1.getText().toString());
           Float temp2 = 0.0f; // /33.8 or *33.8

           if (radio1.isChecked()) { // 섭씨
               temp2 = temp1 / 33.8f;
               input1.setText(temp2.toString());
               unit.setText("℃");
           } else if (radio2.isChecked()) { // 화씨
               temp2 = temp1 * 33.8f;
               input1.setText(temp2.toString());
               unit.setText("℉");
           } else {
               temp2 = 0.0f;
               input1.setText(temp2.toString());
           }
       } catch (NumberFormatException e) {
           Toast.makeText(getApplicationContext(), "숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
       }
   }

   public void onButtonReset(View view) {
       radio1.setChecked(true);
       radio2.setChecked(false);
       input1.setText("");
       unit.setText("℃");
   }
}
