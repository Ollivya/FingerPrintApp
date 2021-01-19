package com.strathmore.fingerprintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.strathmore.fingerprintapp.AccountActivity.LoginActivity;


public class WelcomePage extends AppCompatActivity {

    private Button btnAdmin, btnStudent, btnLecturer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        btnAdmin = (Button) findViewById(R.id.button_admin);
        btnStudent = (Button) findViewById(R.id.button_student);
        btnLecturer = (Button) findViewById(R.id.button_lectuer);


        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenStudentLogin();
            }
        });
    }


    public void OpenStudentLogin() {
        Intent intent = new Intent(this, StudentLogin.class);
        startActivity(intent);


        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

    }

    public void openNewActivity() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


        btnLecturer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLecturerLogin();
            }
        });

    }

    public void  OpenLecturerLogin(){
        Intent intent = new Intent(this,LecturerLogin.class);
        startActivity(intent);

    }

}