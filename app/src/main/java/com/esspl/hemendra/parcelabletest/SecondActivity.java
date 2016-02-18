package com.esspl.hemendra.parcelabletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.esspl.hemendra.parcelabletest.model.ContactInfo;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private TextView data_holder;
    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent dataFromMainActivity = getIntent();
        data_holder = (TextView) findViewById(R.id.data_holder);
        //ContactInfo info = dataFromMainActivity.getExtras().getParcelable("contactInfo");
        //Log.d(TAG, "onCreate: ================================================info:"+info.getAddress()+info.getName());
        List<ContactInfo> contactInfoList = dataFromMainActivity.getParcelableArrayListExtra("contactInfo");
        Log.d(TAG, "onCreate: Size of contact info list : " + contactInfoList.size());
        for (ContactInfo info: contactInfoList)
            Log.d(TAG, "onCreate: "+info.getName()+"----"+info.getAddress()+ "------"+info.getIndex());
        //data_holder.setText(info.getName() + "          "+ info.getAddress());

    }

}
