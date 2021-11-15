package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String FILENAME = "test.txt";
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.edit1);
        Button readButton  = (Button) findViewById(R.id.button1);
        readButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput(FILENAME);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    edit.setText(new String(buffer));
                    fis.close();
                } catch (IOException e) {
                }
            }
        }); // of setOnClickListener

        Button writeButton = (Button) findViewById(R.id.button2);
        writeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(edit.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e) {
                }
            }
        }); // of setOnClickListener
    } // of onCreate
} // of MainActivity
