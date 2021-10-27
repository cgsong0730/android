package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showFragment(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.button1:
                ft.replace(R.id.frame_container, new Fragment1(), "one");
                ft.commitAllowingStateLoss();
                break;
            case R.id.button2:
                ft.replace(R.id.frame_container, new Fragment2(), "two");
                ft.commitAllowingStateLoss();
                break;
        }
    } // of showFragment
} // of MainActivity
