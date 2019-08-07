package com.simple.simplehealth.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simple.simplehealth.R;


public class ShoulderActivity extends AppCompatActivity {

    Button Shoulder_btn1,Shoulder_btn2,Shoulder_btn3,Shoulder_btn4,Shoulder_btn5,Shoulder_btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder);

        Shoulder_btn1 = findViewById(R.id.Shoulder_btn1);
        Shoulder_btn2 = findViewById(R.id.Shoulder_btn2);
        Shoulder_btn3 = findViewById(R.id.Shoulder_btn3);
        Shoulder_btn4 = findViewById(R.id.Shoulder_btn4);
        Shoulder_btn5 = findViewById(R.id.Shoulder_btn5);
        Shoulder_btn6 = findViewById(R.id.Shoulder_btn6);

        Shoulder_btn1.setOnClickListener(click);
        Shoulder_btn2.setOnClickListener(click);
        Shoulder_btn3.setOnClickListener(click);
        Shoulder_btn4.setOnClickListener(click);
        Shoulder_btn5.setOnClickListener(click);
        Shoulder_btn6.setOnClickListener(click);

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.Shoulder_btn1:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%B0%80%EB%A6%AC%ED%84%B8+%ED%94%84%EB%A0%88%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Shoulder_btn2:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EC%82%AC%EC%9D%B4%EB%93%9C+%EB%A0%88%ED%84%B0%EB%9F%B4+%EB%A0%88%EC%9D%B4%EC%A6%88"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Shoulder_btn3:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%8D%A4%EB%B2%A8+%ED%94%84%EB%A0%88%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Shoulder_btn4:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%94%84%EB%9F%B0%ED%8A%B8+%EB%A0%88%EC%9D%B4%EC%A6%88"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Shoulder_btn5:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%8D%A4%EB%B2%A8+%EC%88%84%EB%8D%94+%ED%94%84%EB%A0%88%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Shoulder_btn6:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%B2%A4%ED%8A%B8%EC%98%A4%EB%B2%84+%EB%A0%88%ED%84%B0%EB%9F%B4+%EB%A0%88%EC%9D%B4%EC%A6%88"))
                            .setPackage("com.google.android.youtube"));
                    break;

            }

        }
    };

}
