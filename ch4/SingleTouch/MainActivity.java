package com.example.singletouch;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    protected class MyView extends View {
        int x = 100, y = 100;
        String str;
        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.YELLOW);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setTextSize(30);
            canvas.drawCircle(x, y, 100, paint);
            canvas.drawText("Action:"+str, 0, 100, paint);
            paint.setColor(Color.BLACK);
            canvas.drawText("("+x+","+y+")", x, y, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int) event.getX();
            y = (int) event.getY();
            if (event.getAction() == MotionEvent.ACTION_DOWN)
                str = "ACTION_DOWN";
            if (event.getAction() == MotionEvent.ACTION_MOVE)
                str = "ACTION_MOVE";
            if (event.getAction() == MotionEvent.ACTION_UP)
                str = "ACTION_UP";
            invalidate();
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);
    }
}
