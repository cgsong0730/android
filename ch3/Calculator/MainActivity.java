package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        TextView labelResult = (TextView) findViewById(R.id.labelResult);
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);

        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());

        int result = 0;

        switch (view.getId()) {
            case R.id.buttonAdd:
                result = num1 + num2;
                labelResult.setText("Result:" + result);
                break;
            case R.id.buttonSubtract:
                result = num1 - num2;
                labelResult.setText("Result:" + result);
                break;
            case R.id.buttonMultiply:
                result = num1 * num2;
                labelResult.setText("Result:" + result);
                break;
            case R.id.buttonDivide:
                result = num1 / num2;
                labelResult.setText("Result:" + result);
                break;
        }
    }
}
