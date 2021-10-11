package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnSelectedDate, btnSelectedTime;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelectedDate = (Button) findViewById(R.id.button1);
        btnSelectedTime = (Button) findViewById(R.id.button2);
        display = (TextView) findViewById(R.id.text1);
    }

    public void onClick(View v){
        if (v == btnSelectedDate) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            datePickerDialog= new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            display.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                    }, mYear, mMonth, mDay
            );
            datePickerDialog.show();
        }
        else if(v == btnSelectedTime) {
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            display.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false
            );
            timePickerDialog.show();
        }
    }

}
