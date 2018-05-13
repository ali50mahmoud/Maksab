package com.example.q8big.maksab;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    public Fragment1() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        // this is data fro recycler view
        CountryItemData[] itemsData = {new CountryItemData("Kuwait", R.drawable.ku),
                new CountryItemData("Egypt", R.drawable.eg),
                new CountryItemData("France", R.drawable.fr),
                new CountryItemData("Chychnya", R.drawable.ch),
                new CountryItemData("morocco", R.drawable.moro),
                new CountryItemData("saudi Arabia", R.drawable.sa)};

        // 2. set layoutManger
        LinearLayoutManager hLayoutMangaer = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(hLayoutMangaer);
        // 3. create an adapter
        CountryAdapter mAdapter = new CountryAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final List<Project> projects;
        final RecyclerView rv;



        projects = new ArrayList<>();
        projects.add(new Project("Gomaira compound", R.drawable.mk1));
        projects.add(new Project("Dubai compund ", R.drawable.mk2));
        projects.add(new Project("Cairo compound", R.drawable.mk3));
        projects.add(new Project("Saudi arabia compound", R.drawable.mk5));



        final CardAdapter adapter = new CardAdapter(projects);
        rv = (RecyclerView) view.findViewById(R.id.recyclerView2);
        rv.setLayoutManager(new LinearLayoutManager(Fragment1.this.getActivity()));
        rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
