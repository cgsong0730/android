package com.example.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class Ball {
    int x, y, xInc = 1, yInc = 1;
    int diameter;
    int WIDTH = 768, HEIGHT = 1000;

    public Ball(int d) {
        this.diameter = d;

        x = (int) (Math.random() * (WIDTH - d) + 3);
        y = (int) (Math.random() * (HEIGHT - d) + 3);

        xInc = (int) (Math.random() * 5 + 1);
        yInc = (int) (Math.random() * 5 + 1);
    }

    public void paint(Canvas g) {
        Paint paint = new Paint();

        if (x < 0 || x > (WIDTH - diameter))
            xInc = -xInc;
        if (y < 0 || y > (HEIGHT - diameter))
            yInc = -yInc;

        x += xInc;
        y += yInc;

        paint.setColor(Color.GRAY);
        g.drawCircle(x, y, diameter, paint);
    }
}


public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    public Ball basket[] = new Ball[10];
    private MyThread thread;

    public MySurfaceView(Context context) {
        super(context);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        thread = new MyThread(holder);

        for (int i = 0; i < 10; i++)
            basket[i] = new Ball(20);
    }

    public MyThread getThread() {
        return thread;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;

        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public class MyThread extends Thread {
        private boolean mRun = false;
        private SurfaceHolder mSurfaceHolder;

        public MyThread(SurfaceHolder surfaceHolder) {
            mSurfaceHolder = surfaceHolder;
        }

        @Override
        public void run() {
            while (mRun) {
                Canvas c = null;
                try {
                    c = mSurfaceHolder.lockCanvas(null);
                    c.drawColor(Color.BLACK);
                    synchronized (mSurfaceHolder) {
                        for (Ball b : basket) {
                            b.paint(c);
                        }
                    }
                } finally {
                    if(c != null) {
                        mSurfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }

        public void setRunning(boolean b) {
            mRun = b;
        }
    }
}
