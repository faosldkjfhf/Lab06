package com.liukevin.lab06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    SharedPreferences sharedPreferences;
    TextView text;
    Button quit;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        text = findViewById(R.id.title);
        quit = findViewById(R.id.quit);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("playboi", sharedPreferences.getInt("playboi", 0) + 1);
                editor.apply();
                text1.setText(String.valueOf(sharedPreferences.getInt("playboi", 0)));
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("steve", sharedPreferences.getInt("steve", 0) + 1);
                editor.apply();
                text2.setText(String.valueOf(sharedPreferences.getInt("steve", 0)));
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("creeper", sharedPreferences.getInt("creeper", 0) + 1);
                editor.apply();
                text3.setText(String.valueOf(sharedPreferences.getInt("creeper", 0)));
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("llama", sharedPreferences.getInt("llama", 0) + 1);
                editor.apply();
                text4.setText(String.valueOf(sharedPreferences.getInt("llama", 0)));
            }
        });


        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                TextView textView = (TextView)v;
                textView.setTextColor(color);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        text1.setText(String.valueOf(sharedPreferences.getInt("playboi", 0)));
        text2.setText(String.valueOf(sharedPreferences.getInt("steve", 0)));
        text3.setText(String.valueOf(sharedPreferences.getInt("creeper", 0)));
        text4.setText(String.valueOf(sharedPreferences.getInt("llama", 0)));
    }
}
