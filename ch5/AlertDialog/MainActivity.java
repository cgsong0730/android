package com.example.alertdialog;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("확인");
        alertDialogBuilder.setMessage("결제를 진행하시겠습니다?");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int witch) {
                        Toast.makeText(MainActivity.this, "결제가 완료되었습니다.",
                                Toast.LENGTH_LONG).show();
                    }
                }
        );
        alertDialogBuilder.setNegativeButton("no",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int witch) {
                        Toast.makeText(MainActivity.this, "결제가 취소되었습니다.",
                                Toast.LENGTH_LONG).show();
                    }

                }
        );
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
