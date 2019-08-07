package com.simple.simplehealth;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab4Fragment extends Fragment {

    View view;
    ProgressBar pro;
    EditText key, weight;
    String Textvalue;
    double key_value = 0;
    double weight_value = 0;
    double key_m = 0;
    double value = 0;
    Button calc;
    TextView TextValue;


    public Tab4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab4, container, false);

        key = view.findViewById(R.id.key);
        weight = view.findViewById(R.id.weight);
        calc = view.findViewById(R.id.calc);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = view.findViewById(R.id.pro);
                try {
                    TextValue = view.findViewById(R.id.TextValue);
                    key_value = Double.parseDouble(key.getText().toString());
                    weight_value = Double.parseDouble(weight.getText().toString());

                }catch (NumberFormatException e) {
                    if (key.getText().toString().matches("") || weight.getText().toString().matches("")) {
                        key.requestFocus();

                        Toast.makeText(getActivity(), "키와 몸무게를 입력하세요", Toast.LENGTH_LONG).show();
                    }
                }
                key_value = key_value / 100;
                value =  weight_value / (key_value * key_value)   ;
                pro.setProgress((int)value);

                Textvalue = String.format("%.2f", value);

                if(value <= 18.5 ) {
                    TextValue.setText("현제 BMI치수는" + Textvalue + " 이므로 저체중 입니다.");
                }else if (value >= 18.5 && value <= 24.9){
                    TextValue.setText("현제 BMI치수는" + Textvalue + " 이므로 정상 입니다.");

                }else if (value >= 25 && value <= 29.9){
                    TextValue.setText("현제 BMI치수는" + Textvalue + " 이므로 과체중 입니다.");
                }else if (value >= 30 && value <= 34.9){
                    TextValue.setText("현제 BMI치수는" + Textvalue + " 이므로 비만 입니다.");
                }else if (value > 35) {
                    TextValue.setText("현제 BMI치수는" + Textvalue + " 이므로 고도비만 입니다.");
                }

                InputMethodManager immhide = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });

        return view;
    }


}
