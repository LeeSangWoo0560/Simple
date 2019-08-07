package com.simple.simplehealth;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Locale;

public class Timer_Service extends Service {
    public static String str_receiver = "com.example.simplehealth";

    SharedPreferences mpref;
    SharedPreferences.Editor mEditor;

    long numvalue;
    private CountDownTimer mCountDownTimer;
    String timeLeftFormatted;
    String int_minutes;
    String date;

    Intent intent;
    boolean restartbool;

    @Nullable @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("1234","서비스 시작");
        Log.i("1234", String.valueOf(int_minutes));

        startTimer();

        /*date = String.valueOf(mpref.getString("data", ""));
        if(date.equals("restart")) {
            startTimer();
        }*/

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intent = new Intent(str_receiver);
        mpref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mEditor = mpref.edit();
        int_minutes = String.valueOf(mpref.getString("minutes", ""));
            numvalue = Long.parseLong(int_minutes) * 60000;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void startTimer() {

        mCountDownTimer = new CountDownTimer(numvalue, 500) {

            @Override
            public void onTick(long millisUntilFinished) {
                numvalue = millisUntilFinished;
                updateCountDownText();
                Log.i("1234", String.valueOf(timeLeftFormatted));
                fn_update(timeLeftFormatted);

                date = String.valueOf(mpref.getString("data", ""));
                if(date.equals("reset")) {
                    Log.i("1234", "리셋타이머 호출");
                    mCountDownTimer.cancel();
                    fn_update("00:00");
                    restartbool = true;
                } else if (date.equals("stop")){
                    mCountDownTimer.cancel();
                }

            }

            @Override
            public void onFinish() {
               // mTimerRunning = false;
                Log.i("1234", "끝");

            }
        }.start();
      //  mTimerRunning = true;

    }

    private void resetTimer() {
        numvalue = Long.parseLong(int_minutes);
        updateCountDownText();

    }

    private void updateCountDownText() {

        int minures = (int) (numvalue / 1000) / 60;
        int seconds = (int) (numvalue / 1000) % 60;

        timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minures, seconds);

        //mTextViewCountDown.setText(timeLeftFormatted);

    }

    private void fn_update(String str_time){
        intent.putExtra("time",str_time);
        sendBroadcast(intent);
    }
}
