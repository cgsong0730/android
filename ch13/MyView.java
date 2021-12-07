package com.example.accelometer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    float x_accel = 0;
    float y_accel = 0;
    float z_accel = 0;

    public void setX_accel(float x_accel) {
        this.x_accel = x_accel;
    }
    public void setY_accel(float y_accel) {
        this.y_accel = y_accel;
    }
    public void setZ_accel(float z_accel) {
        this.z_accel = z_accel;
    }

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setTextSize(30);

        paint.setStrokeWidth((float) (Math.abs(z_accel)*3.0));
        canvas.drawLine(200, 200, 200, 400, paint);
        canvas.drawText("z:" + z_accel, 200, 200, paint);

        paint.setStrokeWidth((float) (Math.abs(x_accel)*3.0));
        canvas.drawLine(200, 400, 400, 400, paint);
        canvas.drawText("x:" + x_accel, 400, 400, paint);

        paint.setStrokeWidth((float) (Math.abs(y_accel)*3.0));
        canvas.drawLine(100, 250, 200, 400, paint);
        canvas.drawText("y:" + y_accel, 100, 250, paint);
    }
}
