package com.example.hazemnabil.islamictodo2;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

/**
 * Created by hazem.nabil on 16/02/2017.
 */

public class PopDatePiker extends DialogFragment implements View.OnClickListener{
    View view1;
    TimePicker tp ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view1 =  inflater.inflate(R.layout.popup_date_piker, container, false);
        tp = (TimePicker) view1.findViewById(R.id.timePicker);
        Button bu = (Button) view1.findViewById(R.id.button);
        bu.setOnClickListener(this);

        return view1;

    }

    @Override
    public void onClick(View v) {
        String mytime;
        int t_h =0 ,t_m = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            mytime = tp.getHour()+":"+tp.getMinute();

            Toast.makeText(getContext(),mytime,Toast.LENGTH_SHORT).show();
            t_h = tp.getHour();
            t_m =tp.getMinute();
        }

        this.dismiss();
        AddTask2 ma = (AddTask2)  getActivity();
        ma.SetDate(t_h,t_m);
    }
}
