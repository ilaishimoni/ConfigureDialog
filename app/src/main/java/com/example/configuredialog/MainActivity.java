package com.example.configuredialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb;
    Intent si;
    final String[] colors={"Red","Green","Blue"};
    LinearLayout lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (LinearLayout) findViewById(R.id.lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);

        return true;

    }

    public void chnage(View view) {
        int[] color = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("choose one color");
        adb.setPositiveButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 355;
                lv.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });


        AlertDialog ad = adb.create();
        ad.show();



    }

    public void chnage_switch(View view) {
        int[] color = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("choose one or more colors");
        adb.setPositiveButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                if(isChecked) color[i] = 255;
                else if (color[i]==255) color[i]=0;
            }
        });
        adb.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                lv.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });




        AlertDialog ad = adb.create();
        ad.show();

    }

    public void reset(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        int[] color = new int[]{255,255,255};
        lv.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
    }

    public void editText(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("enter a message");
        final EditText et=new EditText(this);
        et.setHint("write your message here");
        adb.setView(et);
        adb.setNegativeButton("next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setPositiveButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    public void creditsPage(MenuItem item) {
        si = new Intent(this,MainActivity2.class);
        startActivity(si);

    }
}