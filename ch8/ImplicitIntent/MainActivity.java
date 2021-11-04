package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.call:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)123456789"));
                break;
            case R.id.map:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.30.127.2?z=10"));
                break;
            case R.id.web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                break;
            case R.id.contact:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
