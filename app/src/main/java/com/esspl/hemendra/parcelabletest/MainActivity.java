package com.esspl.hemendra.parcelabletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.esspl.hemendra.parcelabletest.model.ContactInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactInfo contactInfo = new ContactInfo("Hemendra", "Bhubaneswar", 12);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putParcelableArrayListExtra("contactInfo", getContactInfoList());
                startActivity(intent);
            }
        });
    }

    private ArrayList<ContactInfo> getContactInfoList() {

        ArrayList<ContactInfo> contactInfoList = new ArrayList<ContactInfo>();
        ContactInfo contactInfo1 = new ContactInfo("Hemendra", "Bhubaneswar", 12);
        ContactInfo contactInfo2 = new ContactInfo("Sabya", "Cuttack", 13);
        ContactInfo contactInfo3 = new ContactInfo("Subhashis", "Mumbai", 14);
        ContactInfo contactInfo4 = new ContactInfo("Rajesh", "Raipur", 15);

        contactInfoList.add(contactInfo1);
        contactInfoList.add(contactInfo2);
        contactInfoList.add(contactInfo3);
        contactInfoList.add(contactInfo4);

        return contactInfoList;
    }
}
