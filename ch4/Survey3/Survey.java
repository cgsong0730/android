package com.example.ch4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Survey extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radio1 = findViewById(R.id.radio1);
                RadioButton radio2 = findViewById(R.id.radio2);
                RadioButton radio3 = findViewById(R.id.radio3);

                ImageView img1 = findViewById(R.id.image1);
                img1.setVisibility(View.GONE);

                if (radio1.isChecked()) {
                    img1.setImageDrawable(getResources().getDrawable(R.drawable.img6));
                    img1.setVisibility(View.VISIBLE);
                } else if (radio2.isChecked()) {
                    img1.setImageDrawable(getResources().getDrawable(R.drawable.img7));
                    img1.setVisibility(View.VISIBLE);
                } else if (radio3.isChecked()) {
                    img1.setImageDrawable(getResources().getDrawable(R.drawable.img8));
                    img1.setVisibility(View.VISIBLE);
                } else {
                    img1.setVisibility(View.GONE);
                }
            }
        });
    }
}
