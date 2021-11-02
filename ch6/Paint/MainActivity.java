package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    FrameLayout frame;
    ImageButton poubelleButton, eraserButton;
    ImageButton redButton, greenButton, blueButton;

    DrawingPaper drawingPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawingPaper = new DrawingPaper(this);

        redButton = findViewById(R.id.red_button);
        greenButton = findViewById(R.id.green_button);
        blueButton = findViewById(R.id.blue_button);

        poubelleButton = findViewById(R.id.poubelle_button);
        eraserButton = findViewById(R.id.eraser_button);
        frame = findViewById(R.id.frame_container);
        frame.addView(drawingPaper);
    }

    public void onPoubelleButton (View view) {
        drawingPaper.resetPaper();
    }

    public void onEraserButton (View view) {
        drawingPaper.setEraser();
    }

    public void onColorButton (View view) {
        switch (view.getId()) {
            case R.id.red_button:
                drawingPaper.setPaintColor(Color.RED);
                break;
            case R.id.green_button:
                drawingPaper.setPaintColor(Color.GREEN);
                break;
            case R.id.blue_button:
                drawingPaper.setPaintColor(Color.BLUE);
                break;
        }
    }
}
