package com.example.calculator;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick (View view) {
        String str1 = ((EditText)findViewById(R.id.text1)).getText().toString();
        String str2 = ((EditText)findViewById(R.id.text2)).getText().toString();
        TextView resultText = findViewById(R.id.resultText);
        boolean eval1 = true, eval2 = true, eval3 = true;
        int value1 = 0;
        int value2 = 0;
        int result = 0;
        String resultStr = "Result: ";

        if(str1.equals("")) {
            Toast.makeText(getApplicationContext(), "첫번째 피연산자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            eval1 = false;
        }

        if(str2.equals("")) {
            Toast.makeText(getApplicationContext(), "두번째 피연산자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            eval2 = false;
        }

        if(eval1 && eval2) {
            try {
                value1 = Integer.parseInt(str1);
                value2 = Integer.parseInt(str2);

                result = 0;

                if(view.getId() == R.id.plus) {
                    result = value1+value2;
                }
                else if(view.getId() == R.id.minus) {
                    result = value1-value2;
                }
                else if(view.getId() == R.id.multipley) {
                    result = value1*value2;
                }
                else if(view.getId() == R.id.devide) {
                    if(value2 == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나누는 것은 불가능합니다.", Toast.LENGTH_SHORT).show();
                        eval3 = false;
                    } else{
                        result = value1/value2;
                    }
                }

                if(eval3)
                    resultText.setText(resultStr + Integer.toString(result));

            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
