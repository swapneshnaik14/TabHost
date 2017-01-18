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
public class Tatva extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tatva_main, container, false);
        ListView l;
        String [] data={"RaceBot","Dance Dance Revolution","Quarantine","Laser Tag"};

        l=(ListView)rootView.findViewById(R.id.listView);

        ArrayAdapter<String> listViewAdapter=new ArrayAdapter<String>(getActivity(),R.layout.single_row,R.id.textView,data);
        l.setAdapter(listViewAdapter);


        return rootView;
    }

}