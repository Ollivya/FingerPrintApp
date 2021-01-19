package com.strathmore.fingerprintapp.Viewusers;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.strathmore.fingerprintapp.R;



public class ActivityTwo extends AppCompatActivity {


    RecyclerView mUsers_RecyclerView;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        mUsers_RecyclerView = (RecyclerView) findViewById(R.id.users_recyclerview);
        mUsers_RecyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("user"), model.class)
                        .build();


        adapter = new myadapter(options);
        mUsers_RecyclerView.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();


    }

}