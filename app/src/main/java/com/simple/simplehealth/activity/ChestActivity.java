package com.simple.simplehealth.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simple.simplehealth.R;


public class ChestActivity extends AppCompatActivity {

    Button chest_btn1, chest_btn2, chest_btn3, chest_btn4, chest_btn5, chest_btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        chest_btn1 = findViewById(R.id.Chest_btn1);
        chest_btn2 = findViewById(R.id.Chest_btn2);
        chest_btn3 = findViewById(R.id.Chest_btn3);
        chest_btn4 = findViewById(R.id.Chest_btn4);
        chest_btn5 = findViewById(R.id.Chest_btn5);
        chest_btn6 = findViewById(R.id.Chest_btn6);

        chest_btn1.setOnClickListener(click);
        chest_btn2.setOnClickListener(click);
        chest_btn3.setOnClickListener(click);
        chest_btn4.setOnClickListener(click);
        chest_btn5.setOnClickListener(click);
        chest_btn6.setOnClickListener(click);


    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.Chest_btn1:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%B2%A4%EC%B9%98%ED%94%84%EB%A0%88%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Chest_btn2:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EC%9D%B8%ED%81%B4%EB%9D%BC%EC%9D%B8+%EB%B2%A4%EC%B9%98%ED%94%84%EB%A0%88%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Chest_btn3:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%94%A5%EC%8A%A4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Chest_btn4:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%8D%A4%EB%B2%A8+%ED%94%8C%EB%9D%BC%EC%9D%B4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Chest_btn5:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%91%B8%EC%89%AC%EC%97%85"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Chest_btn6:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%8D%A4%EB%B2%A8+%ED%92%80%EC%98%A4%EB%B2%84"))
                            .setPackage("com.google.android.youtube"));
                    break;
            }
        }
    };

}
