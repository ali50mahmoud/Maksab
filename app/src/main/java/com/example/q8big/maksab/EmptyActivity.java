package com.example.q8big.maksab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmptyActivity extends AppCompatActivity {

    ImageView photo;
    TextView nameTxt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);


        Intent i = getIntent();
        final String name =i.getExtras().getString("Name");
        final int photoid =i.getExtras().getInt("PhotoId");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, name, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        photo =(ImageView)findViewById(R.id.project_photo);
        photo.setImageResource(photoid);

        nameTxt = (TextView)findViewById(R.id.project_name);
        nameTxt.setText("Name :"+name);



    }



}
