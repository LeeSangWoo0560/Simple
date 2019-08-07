package com.simple.simplehealth.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simple.simplehealth.R;


public class BackActivity extends AppCompatActivity {

    Button back_btn1,back_btn2,back_btn3,back_btn4,back_btn5,back_btn6,back_btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        back_btn1 = findViewById(R.id.Back_btn1);
        back_btn2 = findViewById(R.id.Back_btn2);
        back_btn3 = findViewById(R.id.Back_btn3);
        back_btn4 = findViewById(R.id.Back_btn4);
        back_btn5 = findViewById(R.id.Back_btn5);
        back_btn6 = findViewById(R.id.Back_btn6);
        back_btn7 = findViewById(R.id.Back_btn7);

        back_btn1.setOnClickListener(click);
        back_btn2.setOnClickListener(click);
        back_btn3.setOnClickListener(click);
        back_btn4.setOnClickListener(click);
        back_btn5.setOnClickListener(click);
        back_btn6.setOnClickListener(click);
        back_btn7.setOnClickListener(click);

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Back_btn1:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%84%B1%EA%B1%B8%EC%9D%B4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Back_btn2:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%A3%A8%EB%A7%88%EB%8B%88%EC%95%88+%EB%8D%B0%EB%93%9C%EB%A6%AC%ED%94%84%ED%8A%B8"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Back_btn3:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EC%8A%A4%EB%AA%A8+%EB%8D%B0%EB%93%9C%EB%A6%AC%ED%94%84%ED%8A%B8"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Back_btn4:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EC%BB%A8%EB%B2%A4%EC%85%94%EB%84%90+%EB%8D%B0%EB%93%9C%EB%A6%AC%ED%94%84%ED%8A%B8"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Back_btn5:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%A0%9B%ED%92%80%EB%8B%A4%EC%9A%B4"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Back_btn6:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EC%8B%9C%ED%8B%B0%EB%93%9C%EB%A1%9C%EC%9A%B0"))
                            .setPackage("com.google.android.youtube"));
                    break;
                case R.id.Back_btn7:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%B0%94%EB%B2%A8%EB%A1%9C%EC%9A%B0"))
                            .setPackage("com.google.android.youtube"));
                    break;
            }

        }
    };
}
