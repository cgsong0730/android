package com.example.randomgraphic;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button btn1;
    MyView myView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;
        int height = size.y;

        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        myView1 = new MyView(this, width, height);

        btn1 = new Button(this);
        btn1.setText("update");
        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myView1.updateCircles();
                    }
                }
        );
        linearLayout.addView(btn1);
        linearLayout.addView(myView1);
        setContentView(linearLayout);

    } // of onCreate
} // of MainActivity

