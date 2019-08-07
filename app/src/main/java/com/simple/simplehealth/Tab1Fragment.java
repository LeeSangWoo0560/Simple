package com.simple.simplehealth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;



/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {
    ViewFlipper v_fl;
    Button logout;
    public Tab1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        v_fl = (ViewFlipper)view.findViewById(R.id.v_fl);

        int imgs[] = {R.drawable.health1,
                R.drawable.health2,
                R.drawable.health3
        };

        for (int image : imgs){
            flliperimages(image);
        }

        return view;
    }

    public void flliperimages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        v_fl.addView(imageView);
        v_fl.setFlipInterval(3000);
        v_fl.setAutoStart(true);

        v_fl.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        v_fl.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
    }//flliperimages()





}
