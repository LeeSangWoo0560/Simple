package com.simple.simplehealth.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simple.simplehealth.R;


public class LegActivity extends AppCompatActivity {

    Button Leg_btn1, Leg_btn2, Leg_btn3, Leg_btn4, Leg_btn5, Leg_btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg);

        Leg_btn1 = findViewById(R.id.Leg_btn1);
        Leg_btn2 = findViewById(R.id.Leg_btn2);
        Leg_btn3 = findViewById(R.id.Leg_btn3);
        Leg_btn4 = findViewById(R.id.Leg_btn4);
        Leg_btn5 = findViewById(R.id.Leg_btn5);
        Leg_btn6 = findViewById(R.id.Leg_btn6);

        Leg_btn1.setOnClickListener(click);
        Leg_btn2.setOnClickListener(click);
        Leg_btn3.setOnClickListener(click);
        Leg_btn4.setOnClickListener(click);
        Leg_btn5.setOnClickListener(click);
        Leg_btn6.setOnClickListener(click);

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.Leg_btn1:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EC%8A%A4%EC%BF%BC%ED%8A%B8"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Leg_btn2:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%94%84%EB%9F%B0%ED%8A%B8+%EC%8A%A4%EC%BF%BC%ED%8A%B8"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Leg_btn3:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%A0%88%EA%B7%B8%EC%BB%AC"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Leg_btn4:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%A0%88%EA%B7%B8+%EC%9D%B5%EC%8A%A4%ED%85%90%EC%85%98"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Leg_btn5:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%A0%88%EA%B7%B8+%ED%94%84%EB%A0%88%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Leg_btn6:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%B0%94%EB%B2%A8+%EB%9F%B0%EC%A7%80"))
                            .setPackage("com.google.android.youtube"));
                    break;

            }

        }
    };

}
