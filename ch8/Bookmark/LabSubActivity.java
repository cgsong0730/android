package com.example.ch8;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LabSubActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = {"www.naver.com", "www.daum.net", "www.google.com", "www.github.com", "www.notion.so"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, values);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " is selected", Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.putExtra("INPUT_TEXT", item);
        setResult(RESULT_OK, intent);
        finish();
    }
}
