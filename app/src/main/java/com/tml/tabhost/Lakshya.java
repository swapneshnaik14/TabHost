package com.tml.tabhost;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by divya on 17/1/17.
 */
public class Lakshya extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.lakshya_main, container, false);

        ListView l;
        String [] data={"Kabaddi","VolleyBall","Rink Football","Open Cricket","Box Cricket","Cage Cricket","Mixed Cricket","Carrom","BasketBall","Table Tennis","Chess","Badminton","ATHLETICS","Tug Of War","Throwball"};

        l=(ListView)rootView.findViewById(R.id.listView3);

        ArrayAdapter<String> listViewAdapter=new ArrayAdapter<String>(getActivity(),R.layout.single_row,R.id.textView,data);
        l.setAdapter(listViewAdapter);

        return rootView;
    }

}