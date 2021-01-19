package com.strathmore.fingerprintapp.Addclass;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.strathmore.fingerprintapp.R;

public class ActivityFive extends AppCompatActivity {

     EditText Lecturer;
     EditText Room;
     Spinner  spinnerCourses;
     Button   Submit;
     DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);


        Lecturer = findViewById (R.id.lecturer);
        Room = findViewById (R.id.Room);
        spinnerCourses = findViewById (R.id.spinnerCourse);
        Submit = findViewById (R.id.submit_button);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Class");

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                insertClassData();

            }
        });


    }

    private void insertClassData(){


        String lecturer = Lecturer.getText().toString();
        String room = Room.getText().toString();
        String course = spinnerCourses.getSelectedItem().toString();

        Class Class = new Class(lecturer,room,course);

        databaseReference.setValue(Class);
        Toast.makeText(ActivityFive.this, "Data Inserted",Toast.LENGTH_SHORT).show();


    }


    }
