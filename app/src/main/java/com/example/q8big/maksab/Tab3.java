package com.example.q8big.maksab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by q8big on 14/03/2018.
 */

public class Tab3 extends Fragment2 {

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.tab3,container,false );
    }
}