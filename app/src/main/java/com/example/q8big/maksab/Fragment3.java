package com.example.q8big.maksab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {


    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v = inflater.inflate(R.layout.fragment_fragment3, container, false);
      String [] values = {" the UAE's oil in the emirate of Abu Dhabi ", "Trucial States Council to promote cooperation among the seven rulers","The UAE's constitution established a federal government that leaves much power to the emirates",
                      "Spacious 5 BR Compound villa with shared pool ","\n" +
              "Nice 4 Bedroom compound villa with Garden ","Live Steps from the Canal with this 4 BR villa" , "Live Steps from the Canal with this 4 BR villa",
      "Live Steps from the Canal with this 4 BR villa","Live Steps from the Canal with this 4 BR villa","Live Steps from the Canal with this 4 BR villa","Live Steps from the Canal with this 4 BR villa" +
              "Live Steps from the Canal with this 4 BR villa","Live Steps from the Canal with this 4 BR villa"};
        Spinner spinner =(Spinner)v.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,values);
        spinner.setAdapter(adapter);




      return v;
    }

}
