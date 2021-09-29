package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void onButtonClick(View view) {
        TextView text1 = (TextView) findViewById(R.id.text2);

        switch (view.getId()) {
            case R.id.button1:
                text1.setText("hello");
                break;
            case R.id.button2:
                text1.setText("world");
                break;
        }
    }
}
