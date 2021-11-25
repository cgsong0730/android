package com.example.moviedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText edit1, edit2, edit3, edit4, edit5;

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

        buttonSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_NAME", edit1.getText().toString());
                intent.putExtra("INPUT_YEAR", edit2.getText().toString());
                intent.putExtra("INPUT_PD", edit3.getText().toString());
                intent.putExtra("INPUT_SCORE", edit4.getText().toString());
                intent.putExtra("INPUT_NATION", edit5.getText().toString());

                setResult(RESULT_OK, intent);
                finish();
            }
        });
        buttonUpdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ACTION", "update");
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
                intent.putExtra("ACTION", "delete");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
