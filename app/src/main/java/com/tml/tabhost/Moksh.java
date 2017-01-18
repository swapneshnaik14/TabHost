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
public class Moksh extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.moksh_main, container, false);

        ListView l;
        String [] data={"Group Dance","Moksh Film Festival","Big Boss 3","AM Rock","Virtual Auction","Solo/Duet Singing","Solo/Duet Dance","Karaoke","LAN Gaming","Rangoli","Face Painting","Paint Without Brush","Inquisitive","Mr and Ms TML","Food Frenzy","Air Hockey","TreasureHunt+CSI","SNAP Photography","Crossfit","Human FoosBall","Tangled","FootPool","Make Your Fair","Quick Buck","Dus Ka Dum","Land Tycoon","Bizence","Biz Jengga","Biz Charades"};

        l=(ListView)rootView.findViewById(R.id.listView2);

        ArrayAdapter<String> listViewAdapter=new ArrayAdapter<String>(getActivity(),R.layout.single_row,R.id.textView,data);
        l.setAdapter(listViewAdapter);

        return rootView;
    }

}