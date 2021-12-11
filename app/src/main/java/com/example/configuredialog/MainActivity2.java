package com.example.configuredialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = (TextView) findViewById(R.id.tv);
        tv.setText("Made by: Ilai Shimoni Teacher: Albert Levi");
    }
}