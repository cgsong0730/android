package com.example.sensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String report = "";
        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ALL);
        report += "전체 센서수: " + sensors.size() + "\n";
        int i = 0;
        for (Sensor s : sensors) {
            report += "" + i++ + " name: " + s.getName() +
                    "\npower: " + s.getPower() +
                    "\nres: " + s.getResolution() +
                    "\nrange: " + s.getMaximumRange() + "\n\n";
        }

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(report);
    }
}
