package com.example.compass;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CompassView extends View {

    float azimuth = 0;
    float pitch = 0;
    float roll = 0;

    public void setAzimuth(float azimuth) {
        this.azimuth = azimuth;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setRoll(float roll) {
        this.roll = roll;
    }

    public CompassView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.YELLOW);
        canvas.save();
        canvas.rotate(-azimuth, 250, 250);
        canvas.drawCircle(250, 250, 200, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText("N", 250, 80, paint);
        canvas.drawText("S", 250, 430, paint);
        canvas.drawRect(240, 80, 260, 430, paint);
        canvas.restore();
    }
}
