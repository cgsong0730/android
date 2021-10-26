package com.example.randomgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    public int WIDTH = 768, HEIGHT = 1000;
    public Ball basket[] = new Ball[50];
    int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.GRAY, Color.MAGENTA, Color.YELLOW, Color.WHITE};

    public MyView(Context context, int width, int height) {
        super(context);
        WIDTH = width;
        HEIGHT = height;
        initView();
    }
    public MyView(Context context, AttributeSet attrs, int width, int height) {
        super(context);
        WIDTH = width;
        HEIGHT = height;
        initView();
    }

    private void initView() {
        for (int i = 0; i < 50; i++){
            int rValue = (int)(Math.random() * 8);
            int rDiameter = (int)(Math.random() * 30 + 1);
            basket[i] = new Ball(rDiameter, colors[rValue]);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        for (int i = 0; i < 50; i++){
            basket[i].paint(canvas);
        }
    }

    public void updateCircles(){
        initView();
        invalidate();
    }

    public class Ball {
        int x, y;
        int diameter;
        int color;

        public Ball(int rd, int rcolor) {
            color = rcolor;
            this.diameter = rd;
            x = (int) (Math.random() * (WIDTH - rd) + 3);
            y = (int) (Math.random() * (HEIGHT - rd) + 3);
        }

        public void paint(Canvas g) {
            Paint paint = new Paint();
            paint.setColor(color);
            g.drawCircle(x, y, diameter, paint);
        }
    } // of Ball
} // of MyView
