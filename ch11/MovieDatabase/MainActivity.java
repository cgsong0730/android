package com.example.moviedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    static final int GET_STRING = 1;
    DatabaseHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, GET_STRING);
            }
        });

        helper = new DatabaseHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
        printDb();
    }

    private void printDb() {
        Cursor cursor = db.rawQuery("SELECT * FROM contacts", null);
        startManagingCursor(cursor);

        String[] from = {"name", "year", "pd", "score", "nation"};

        int[] to = {R.id.name, R.id.year, R.id.pd, R.id.score, R.id.nation};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.listitem, cursor, from, to);
        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, GET_STRING);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING && resultCode == RESULT_OK) {
            db.execSQL("INSERT INTO contacts VALUES (null, " +
                    "'" +data.getStringExtra("INPUT_NAME")+ "', "+
                    "'" +data.getStringExtra("INPUT_YEAR")+ "', "+
                    "'" +data.getStringExtra("INPUT_PD")+ "', "+
                    "'" +data.getStringExtra("INPUT_SCORE")+ "', "+
                    "'" +data.getStringExtra("INPUT_NATION")+ "');");
            printDb();
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
