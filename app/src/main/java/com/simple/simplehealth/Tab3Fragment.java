package com.simple.simplehealth;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3Fragment extends Fragment {
    View view;
    int today;
    GridView mGridView;
    DateAdapter adapter;
    ArrayList arrData, arrData2;
    Calendar mCal;
    int thisYear;
    int thisMonth;
    TextView maintext;

    Calendar mCalToday;
    public Tab3Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter = (DateAdapter) mGridView.getAdapter();
        adapter.notifyDataSetChanged();
        mGridView.setAdapter(adapter);
        Log.e("start", "startstartstart");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab3, container, false);

        Button prev = view.findViewById(R.id.prev);
        Button next = view.findViewById(R.id.next);
        maintext = view.findViewById(R.id.maintext);
        mGridView = view.findViewById(R.id.calGrid);

        // Calendar 객체 생성

        mCal = Calendar.getInstance();

        thisYear = mCal.get(Calendar.YEAR);
        thisMonth = mCal.get(Calendar.MONTH)+1;





        // 달력 세팅
        setCalendarDate(thisYear, thisMonth);

        Log.i("1234", thisYear+ ", " + thisMonth);

        prev.setOnClickListener(click);
        next.setOnClickListener(click);

        return view;
    }

    public void setCalendarDate( int year, int month){
        arrData = new ArrayList<CalData>();
        arrData2 = new ArrayList<CalData>();

        mCalToday = Calendar.getInstance();


        mCalToday.set(year, month-1, 1);
        Log.i("1234", mCalToday+ ", ");
        // 1일이 무슨 요일인지 찾는다
        final int startday = mCalToday.get(Calendar.DAY_OF_WEEK);




        Log.i("12345", startday+ ", ");

        if(startday != 1)
        {
            for(int i=0; i<startday-1; i++)
            {
                arrData.add(null);
                arrData2.add(null);
            }
        }

        // 요일은 +1해야 되기때문에 달력에 요일을 세팅할때에는 -1 해준다.
        //  mCal.set(Calendar.MONTH, month-1);
        mCal.set(year, month-1, 1);

        maintext.setText(year + " / " + month);

        // 해당월 마지막 날짜 구하기
        for (int i = 0; i < mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            arrData.add(i+1);
            arrData2.add(i+1);
            Log.i("1234567", i+"");

        }


        adapter = new DateAdapter(getActivity(), arrData, arrData2);
        adapter.date(thisYear, thisMonth, startday);
        mGridView = (GridView)view.findViewById(R.id.calGrid);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                today = (position-startday)+2;
                adapter.date(today);
                Toast.makeText(getActivity(), thisYear+"년"+ thisMonth + "월" + ((position-startday)+2) + "일이 선택 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MemoActivity.class);
                intent.putExtra("thisYear", thisYear);
                intent.putExtra("thisMonth", thisMonth);
                intent.putExtra("today", today);
                startActivity(intent);

            }
        });


    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.prev:
                    if(thisMonth > 1) {
                        thisMonth--;
                        setCalendarDate(thisYear, thisMonth);
                    } else {
                        thisYear--;
                        thisMonth = 12;
                        setCalendarDate(thisYear, thisMonth);
                    }
                    break;

                case R.id.next:
                    if(thisMonth < 12) {
                        thisMonth++;
                        setCalendarDate(thisYear, thisMonth);
                    } else {
                        thisYear++;
                        thisMonth = 1;
                        setCalendarDate(thisYear, thisMonth);
                    }
                    break;
            }


        }
    };

}

// GridView와 연결해주기위한 어댑터 구성
class DateAdapter extends BaseAdapter {
    private Context context;
    private ArrayList arrData, arrData2;
    private LayoutInflater inflater;

    int y, m, d, s;

    public DateAdapter(Context c, ArrayList arr, ArrayList arr2) {
        this.context = c;
        this.arrData = arr;
        this.arrData2 = arr2;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public DateAdapter() {

    }


    public int getCount() {
        return arrData.size();
    }

    public Object getItem(int position) {
        return arrData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.viewitem, parent, false);
        }

        Calendar mCalToday = Calendar.getInstance();
        //mCalToday.set(y, m-1, 1);

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        String day = dayFormat.format(currentTime);
        int day_num = Integer.valueOf(day);
        int day1 = s + day_num - 2;

        Log.i("position", "" + day1);
        Log.i("position2", "" + day_num);
        Log.i("position3", "" + s);


        //Log.i("position", ""+position);

        TextView ViewText = (TextView) convertView.findViewById(R.id.ViewText);
        ViewText.setText(arrData.get(position) + "");
        int thisYear = mCalToday.get(Calendar.YEAR);
        int thisMonth = mCalToday.get(Calendar.MONTH) + 1;


        // 오늘 날짜 표시
        if (thisYear == y && thisMonth == m && day1 == position) {
            ViewText.setTextColor(0xff6d4c41);
            ViewText.setTypeface(null, Typeface.BOLD);
            ViewText.setTextSize(20);
        }

        if (arrData.get(position) == null)
            ViewText.setText("");




//        TextView TextTitle = convertView.findViewById(R.id.TextTitle);
//        TextTitle.setText(arrData2.get(position) + "");
//        if (arrData2.get(position) == null)
//            TextTitle.setText("");
//
//        MyDBHandler myDBHandler = new MyDBHandler(context, null, null, 1);
//
//        String strYear = String.valueOf(y);
//        String strMonth = String.valueOf(m);
//        String strDay = String.valueOf(d);
//
//        String id = strYear + strMonth + strDay;
//        Log.e("id", id + " " + s + " " + position);
//        Product product = myDBHandler.findProduct(id);
//
//        try {
//            Log.e("w", product.get_weight());
//            if ((d + s-2) == position) {
//                TextTitle.setText(String.valueOf(product.get_weight())+ "kg");
//                TextTitle.setTextColor(0xFFFF0000);
//            }
//        } catch (NullPointerException e) {
//        }



//        Product product = new Product();
//        String id = product.get_id();
//        myDBHandler.findProduct(id);
//        if()

        return convertView;

    }

    public void date(int year, int month, int start) {
        y = year;
        m = month;
        s = start;
    }

    public void date(int day) {
        d = day;
    }


}
