package com.example.moviedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText edit1, edit2, edit3, edit4, edit5;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);
        edit5 = (EditText) findViewById(R.id.edit5);

        Button buttonSave = (Button) findViewById(R.id.button_save);
        Button buttonUpdate = (Button) findViewById(R.id.button_update);
        Button buttonDelete = (Button) findViewById(R.id.button_delete);

        Intent intent = getIntent();
        String actionRequest = intent.getStringExtra("ACTION_REQUEST");
        switch (actionRequest) {
            case "CREATE":
                buttonSave.setVisibility(View.VISIBLE);
                buttonUpdate.setVisibility(View.INVISIBLE);
                buttonDelete.setVisibility(View.INVISIBLE);
                break;
            case "UPDATE":
                buttonSave.setVisibility(View.INVISIBLE);
                buttonUpdate.setVisibility(View.VISIBLE);
                buttonDelete.setVisibility(View.VISIBLE);

                id = intent.getStringExtra("ID");
                edit1.setText(intent.getStringExtra("NAME"));
                edit2.setText(intent.getStringExtra("YEAR"));
                edit3.setText(intent.getStringExtra("PD"));
                edit4.setText(intent.getStringExtra("SCORE"));
                edit5.setText(intent.getStringExtra("NATION"));
                break;
        }

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ACTION_RESULT", "CREATE");
                intent.putExtra("INPUT_NAME", edit1.getText().toString());
                intent.putExtra("INPUT_YEAR", edit2.getText().toString());
                intent.putExtra("INPUT_PD", edit3.getText().toString());
                intent.putExtra("INPUT_SCORE", edit4.getText().toString());
                intent.putExtra("INPUT_NATION", edit5.getText().toString());

                setResult(RESULT_OK, intent);
                finish();
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ACTION_RESULT", "UPDATE");
                intent.putExtra("ID", id);
                intent.putExtra("INPUT_NAME", edit1.getText().toString());
                intent.putExtra("INPUT_YEAR", edit2.getText().toString());
                intent.putExtra("INPUT_PD", edit3.getText().toString());
                intent.putExtra("INPUT_SCORE", edit4.getText().toString());
                intent.putExtra("INPUT_NATION", edit5.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ACTION_RESULT", "DELETE");
                intent.putExtra("ID", id);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    } // of onCreate()
}
