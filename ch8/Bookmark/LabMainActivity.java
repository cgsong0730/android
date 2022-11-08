package com.example.ch8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LabMainActivity extends AppCompatActivity {

    static final int GET_STRING = 1;
    TextView text;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);

        text = (TextView) findViewById(R.id.text1);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LabMainActivity.this, LabSubActivity.class);
                startActivityForResult(intent, GET_STRING);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + url));
                startActivity(intent);
                finish();
            }
        });
        overridePendingTransition(0, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING && resultCode == RESULT_OK) {
            url = data.getStringExtra("INPUT_TEXT").toString();
            text.setText(url);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
