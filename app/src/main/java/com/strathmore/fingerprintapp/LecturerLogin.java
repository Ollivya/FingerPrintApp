package com.strathmore.fingerprintapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LecturerLogin extends AppCompatActivity {

    private EditText Emailtxt, Passwordtxt;
    private FirebaseAuth firebaseAuth;
    private Button btnLecturerLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_login);


        firebaseAuth= FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(LecturerLogin.this, LecturerMenu.class));
            finish();
        }

        setContentView(R.layout.activity_lecturer_login);
        Emailtxt = (EditText) findViewById(R.id.email_edittext);
        Passwordtxt = (EditText) findViewById(R.id.enterpass_edittext);
        btnLecturerLogin = (Button) findViewById(R.id.lec_login);

        //Get Firebase auth instance
        firebaseAuth= FirebaseAuth.getInstance();



        btnLecturerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Emailtxt.getText().toString();
                final String password = Passwordtxt.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }


                //authenticate user
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LecturerLogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        Passwordtxt.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(LecturerLogin.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(LecturerLogin.this, LecturerMenu.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
