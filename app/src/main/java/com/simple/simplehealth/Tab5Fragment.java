package com.simple.simplehealth;


import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab5Fragment extends Fragment {
    NotificationCompat.Builder notificationBuilder;
    NotificationManager notifyMgr;


    View view;
    private Button btn_start, btn_cancel, btn_stop;
    private TextView text_view_countdown;
    private EditText editnum;

    SharedPreferences mpref;
    SharedPreferences.Editor mEditor;

    boolean notificationbool;
    boolean servicebool;
    String str_time;

    public Tab5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab5, container, false);
        mpref = PreferenceManager.getDefaultSharedPreferences(getContext());
        mEditor = mpref.edit();

        btn_start = view.findViewById(R.id.button_start);
        btn_stop = view.findViewById(R.id.button_stop);
        btn_cancel = view.findViewById(R.id.button_reset);
        editnum = view.findViewById(R.id.editnum);
        text_view_countdown = view.findViewById(R.id.text_view_countdown);

        servicebool = isLaunchingService(getContext());


        if(servicebool){
            btn_start.setEnabled(false);
            btn_stop.setEnabled(true);
            btn_cancel.setEnabled(true);
        }else{
            btn_start.setEnabled(true);
            btn_stop.setEnabled(false);
            btn_cancel.setEnabled(false);
        }

        btn_start.setOnClickListener(onclick);
        btn_cancel.setOnClickListener(onclick);
        btn_stop.setOnClickListener(onclick);





        return view;
    }

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_start:
                    try {
                        String getEdit = editnum.getText().toString();
                        if (getEdit.getBytes().length <= 0) {
                            throw new Exception();
                        }

                        if(btn_start.getText().toString().equals("시작")){

                            btn_start.setEnabled(false);
                            btn_stop.setEnabled(true);
                            btn_cancel.setEnabled(true);

                            mEditor.clear();
                            mEditor.putString("minutes", editnum.getText().toString()).commit();
                            mEditor.putBoolean("restart", true);
                            Intent intent_service = new Intent(getActivity(), Timer_Service.class);
                            getActivity().startService(intent_service);
                            Log.i("1234","클릭되었습니다");

                        }else {
                            // 일시정지
                            mEditor.clear();
                            mEditor.putString("data", "restart").commit();
                            mEditor.putBoolean("restart", false);
                            Intent intent_service = new Intent(getActivity(), Timer_Service.class);
                            getActivity().startService(intent_service);
                            btn_start.setEnabled(false);
                            btn_stop.setEnabled(true);
                            btn_cancel.setEnabled(true);
                        }


                    }catch (Exception e){
                        Toast.makeText(getActivity(), "시간(분)을 입력하세요", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.button_stop:
                    btn_start.setEnabled(true);
                    btn_stop.setEnabled(false);
                    btn_cancel.setEnabled(true);
                    btn_start.setText("다시시작");

                    mEditor.clear();
                    mEditor.putString("data", "stop").commit();

                    break;
                case R.id.button_reset:
                    btn_start.setEnabled(true);
                    btn_stop.setEnabled(false);
                    btn_cancel.setEnabled(false);
                    btn_start.setText("시작");

                    mEditor.clear();
                    mEditor.putString("data", "reset").commit();
                    Intent intent = new Intent(getActivity(), Timer_Service.class);
                    getActivity().stopService(intent);



                    break;
            }

        }
    };

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            str_time = intent.getStringExtra("time");
            text_view_countdown.setText(str_time);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(Timer_Service.str_receiver));
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(broadcastReceiver);
    }

    public Boolean isLaunchingService(Context mContext){

        ActivityManager manager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (Timer_Service.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return  false;
    }
}
