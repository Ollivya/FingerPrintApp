package com.strathmore.fingerprintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivitySix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        TextView txtInfo6 = (TextView)findViewById(R.id.txtInfo6);
        if(getIntent() != null)
        {
            String info6 = getIntent().getStringExtra("info6");
            txtInfo6.setText(info6);
        }
    }
}