package com.example.transition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    Button fadeButton, slideButton, explodeButton;
    ImageView imageView1;
    boolean visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.layout);
        fadeButton = (Button) findViewById(R.id.fade);
        slideButton = (Button) findViewById(R.id.slide);
        explodeButton = (Button) findViewById(R.id.explode);
        imageView1 = (ImageView) findViewById(R.id.imageView1);

        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(layout, new Fade());
                visible = !visible;
                imageView1.setVisibility(visible ? View.VISIBLE:View.GONE);
            }
        });

        slideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(layout, new Slide());
                visible = !visible;
                imageView1.setVisibility(visible? View.VISIBLE:View.GONE);
            }
        });

        explodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(layout, new Explode());
                visible = !visible;
                imageView1.setVisibility(visible? View.VISIBLE:View.GONE);
            }
        });

    }
}
