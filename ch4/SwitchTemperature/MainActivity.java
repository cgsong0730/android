package com.example.switchtemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {

        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);
        EditText input1 = findViewById(R.id.input1);
        Float temp1 = Float.parseFloat(input1.getText().toString());
        Float temp2 = 0.0f;
        // 33.8

        if (radio1.isChecked()) { // 섭씨
            temp2 = temp1 / 33.8f;
            input1.setText(temp2.toString());
        }
        else if (radio2.isChecked()) { // 화씨
            temp2 = temp1 * 33.8f;
            input1.setText(temp2.toString());
        }
        else {
            temp2 = 0.0f;
            input1.setText(temp2.toString());
        }
    }

    public void onButtonReset(View view) {
        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);
        EditText input1 = findViewById(R.id.input1);

        radio1.setChecked(false);
        radio2.setChecked(false);
        input1.setText("");
    }
}
