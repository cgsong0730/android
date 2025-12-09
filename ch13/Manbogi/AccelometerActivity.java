package com.example.pro3;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.List;

public class AccelometerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelometer;
    MyView view;

    FixedSizeQueue<Float> recentSensorData;
    List<Float> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new MyView(this);
        setContentView(view);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        recentSensorData = new FixedSizeQueue<>(5);
        dataList = recentSensorData.getElementsAsList();
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelometer, SensorManager.SENSOR_DELAY_UI);
    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            view.setX_accel(event.values[0]);
            view.setY_accel(event.values[1]);
            view.setZ_accel(event.values[2]);

            recentSensorData.add(event.values[1]);

            dataList = recentSensorData.getElementsAsList();
            double average = dataList.stream().mapToDouble(Float::doubleValue).average().orElse(0.0);

            view.setAverage(average);
            view.invalidate();
        }
    }
}
