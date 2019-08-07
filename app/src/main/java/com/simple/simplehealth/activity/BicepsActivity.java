package com.simple.simplehealth.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simple.simplehealth.R;


public class BicepsActivity extends AppCompatActivity {

    Button Biceps_btn1, Biceps_btn2, Biceps_btn3, Biceps_btn4, Biceps_btn5, Biceps_btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);

        Biceps_btn1 = findViewById(R.id.Biceps_btn1);
        Biceps_btn2 = findViewById(R.id.Biceps_btn2);
        Biceps_btn3 = findViewById(R.id.Biceps_btn3);
        Biceps_btn4 = findViewById(R.id.Biceps_btn4);
        Biceps_btn5 = findViewById(R.id.Biceps_btn5);
        Biceps_btn6 = findViewById(R.id.Biceps_btn6);


        Biceps_btn1.setOnClickListener(click);
        Biceps_btn2.setOnClickListener(click);
        Biceps_btn3.setOnClickListener(click);
        Biceps_btn4.setOnClickListener(click);
        Biceps_btn5.setOnClickListener(click);
        Biceps_btn6.setOnClickListener(click);

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.Biceps_btn1:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%8D%A4%EB%B2%A8%EC%BB%AC"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Biceps_btn2:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%B0%94%EB%B2%A8%EC%BB%AC"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Biceps_btn3:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%97%A4%EB%A8%B8%EC%BB%AC"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Biceps_btn4:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%93%9C%EB%9E%98%EA%B7%B8+%EC%BB%AC"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Biceps_btn5:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EC%BB%A8%EC%84%BC%ED%8A%B8%EB%A0%88%EC%9D%B4%EC%85%98+%EC%BB%AC"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Biceps_btn6:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%94%84%EB%A6%AC%EC%B3%90+%EC%BB%AC"))
                            .setPackage("com.google.android.youtube"));
                    break;

            }

        }
    };
}
