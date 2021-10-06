package com.example.mymenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item1 = menu.add(0, 1, 0, "C사과");
        item1.setIcon(R.drawable.ic_launcher_background);
        item1.setAlphabeticShortcut('a');

        menu.add(0, 2, 0, "C포도").setIcon(R.drawable.ic_launcher_background);
        menu.add(0, 3, 0, "C바나나").setIcon(R.drawable.ic_launcher_background);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.apple:
                Toast.makeText(getBaseContext(), "C사과", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.grape:
                Toast.makeText(getBaseContext(), "C포도", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.banana:
                Toast.makeText(getBaseContext(), "C바나나", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
