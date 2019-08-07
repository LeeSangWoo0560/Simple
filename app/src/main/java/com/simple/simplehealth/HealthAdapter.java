package com.simple.simplehealth;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simple.simplehealth.activity.AbsActivity;
import com.simple.simplehealth.activity.BackActivity;
import com.simple.simplehealth.activity.BicepsActivity;
import com.simple.simplehealth.activity.ChestActivity;
import com.simple.simplehealth.activity.LegActivity;
import com.simple.simplehealth.activity.ShoulderActivity;
import com.simple.simplehealth.activity.TricepsActivity;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ViewHolder> {

    private String[] titles = {"가슴", "등", "다리", "어깨", "복근", "이두근", "삼두근"};
    private Intent intent;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;


        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textname);

        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab2item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(titles[i]);

        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                switch (i) {
                    case 0:
                        intent = new Intent(context, ChestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, BackActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, LegActivity.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, ShoulderActivity.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(context, AbsActivity.class);
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(context, BicepsActivity.class);
                        context.startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(context, TricepsActivity.class);
                        context.startActivity(intent);
                        break;

                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


}
