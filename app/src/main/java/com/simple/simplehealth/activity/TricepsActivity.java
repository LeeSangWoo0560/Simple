package com.simple.simplehealth.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simple.simplehealth.R;


public class TricepsActivity extends AppCompatActivity {

    Button Triceps_btn1,Triceps_btn2,Triceps_btn3,Triceps_btn4,Triceps_btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps);

        Triceps_btn1 = findViewById(R.id.Triceps_btn1);
        Triceps_btn2 = findViewById(R.id.Triceps_btn2);
        Triceps_btn3 = findViewById(R.id.Triceps_btn3);
        Triceps_btn4 = findViewById(R.id.Triceps_btn4);
        Triceps_btn5 = findViewById(R.id.Triceps_btn5);

        Triceps_btn1.setOnClickListener(click);
        Triceps_btn2.setOnClickListener(click);
        Triceps_btn3.setOnClickListener(click);
        Triceps_btn4.setOnClickListener(click);
        Triceps_btn5.setOnClickListener(click);

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.Triceps_btn1:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%82%A5%EB%B0%B1"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Triceps_btn2:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%8A%B8%EB%9D%BC%EC%9D%B4%EC%85%89%EC%8A%A4+%EC%9D%B5%EC%8A%A4%ED%85%90%EC%85%98"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Triceps_btn3:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%8A%B8%EB%9D%BC%EC%9D%B4%EC%85%89%EC%8A%A4+%ED%94%84%EB%A0%88%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Triceps_btn4:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%91%B8%EC%89%AC%EB%8B%A4%EC%9A%B4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Triceps_btn5:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%B2%A4%EC%B9%98+%EB%94%A5%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;


            }

        }
    };

}
