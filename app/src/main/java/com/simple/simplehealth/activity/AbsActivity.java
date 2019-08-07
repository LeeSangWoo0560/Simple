package com.simple.simplehealth.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simple.simplehealth.R;


public class AbsActivity extends AppCompatActivity {

    Button Abs_btn1,Abs_btn2,Abs_btn3,Abs_btn4,Abs_btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);

        Abs_btn1 = findViewById(R.id.Abs_btn1);
        Abs_btn2 = findViewById(R.id.Abs_btn2);
        Abs_btn3 = findViewById(R.id.Abs_btn3);
        Abs_btn4 = findViewById(R.id.Abs_btn4);
        Abs_btn5 = findViewById(R.id.Abs_btn5);

        Abs_btn1.setOnClickListener(click);
        Abs_btn2.setOnClickListener(click);
        Abs_btn3.setOnClickListener(click);
        Abs_btn4.setOnClickListener(click);
        Abs_btn5.setOnClickListener(click);

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.Abs_btn1:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%96%89%EC%9E%89+%EB%A0%88%EA%B7%B8+%EB%A0%88%EC%9D%B4%EC%A6%88"))
                            .setPackage("com.google.android.youtube"));
                    break;

                case R.id.Abs_btn2:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%8D%A4%EB%B2%A8+%EC%82%AC%EC%9D%B4%EB%93%9C+%EB%B0%B4%EB%93%9C"))
                            .setPackage("com.google.android.youtube"));
                    break;

                case R.id.Abs_btn3:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%EB%A0%88%EA%B7%B8+%EB%A0%88%EC%9D%B4%EC%A6%88"))
                            .setPackage("com.google.android.youtube"));
                    break;

                case R.id.Abs_btn4:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%81%AC%EB%9F%B0%EC%B9%98"))
                            .setPackage("com.google.android.youtube"));
                    break;

                case R.id.Abs_btn5:
                    startActivity(new Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse("https://www.youtube.com/results?search_query=%ED%94%8C%EB%9E%AD%ED%81%AC"))
                            .setPackage("com.google.android.youtube"));
                    break;

            }

        }
    };

}
