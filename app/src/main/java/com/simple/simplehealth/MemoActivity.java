package com.simple.simplehealth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    TextView today, TextTitle;

    EditText db_weight;
    EditText db_diet_hour;
    EditText db_diet_minute;
    EditText db_health;

    Button btn_add, backbtn;

    int thisYear;
    int thisMonth;
    int day;

    String strYear, strMonth, strDay;

    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        today = findViewById(R.id.today);

        Intent intent = new Intent(getIntent());

        thisYear = intent.getExtras().getInt("thisYear");
        thisMonth = intent.getExtras().getInt("thisMonth");
        day = intent.getExtras().getInt("today");

        today.setText(thisYear + "년" + thisMonth + "월" + day + "일");

        strYear = String.valueOf(thisYear);
        strMonth = String.valueOf(thisMonth);
        strDay = String.valueOf(day);

        db_weight = findViewById(R.id.db_weight);
        db_diet_hour = findViewById(R.id.db_diet_hour);
        db_diet_minute = findViewById(R.id.db_diet_minute);
        db_health = findViewById(R.id.db_health);
        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        scrollView = findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                db_health.requestFocus();

                // 키보드 보이게 하기
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                return true;
            }
        });



        db_weight.setText("");
        db_diet_hour.setText("");
        db_diet_minute.setText("");
        db_health.setText("");

        btn_add = findViewById(R.id.btn_add);
        lookupProduct();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDBHandler myDBHandler = new MyDBHandler(MemoActivity.this, null, null, 1);

                String id = strYear + strMonth + strDay;

                String weight = db_weight.getText().toString();
                String diet_hour = db_diet_hour.getText().toString();
                String diet_minute = db_diet_minute.getText().toString();
                String health = db_health.getText().toString();

                Product product = new Product(id, weight, diet_hour, diet_minute, health);

                if(btn_add.getText().toString().equals("저장")) {
                    myDBHandler.addProduct(product);
                    Toast.makeText(MemoActivity.this, "저장이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                    Log.i("database" , ""+ id);

                    finish();
                }else if(btn_add.getText().toString().equals("수정")){
                    myDBHandler.updateProduct(product);
                    Toast.makeText(MemoActivity.this, "수정이 완료 되었습니다.", Toast.LENGTH_SHORT).show();

                    finish();
                }
            }
        });

    }

    public void lookupProduct() {
        MyDBHandler myDBHandler = new MyDBHandler(MemoActivity.this, null, null, 1);


        String id = strYear + strMonth + strDay;
        Product product = myDBHandler.findProduct(id);

        if(product != null) {
            db_weight.setText(String.valueOf(product.get_weight()));
            db_diet_hour.setText(String.valueOf(product.get_hour()));
            db_diet_minute.setText(String.valueOf(product.get_minute()));
            db_health.setText(String.valueOf(product.get_health()));
            btn_add.setText("수정");
        }else{
            db_weight.setText("");
            db_diet_hour.setText("");
            db_diet_minute.setText("");
            db_health.setText("");
            btn_add.setText("저장");
        }



    }



}
