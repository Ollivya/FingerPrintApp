package com.strathmore.fingerprintapp.UserAuthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.app.DatePickerDialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.strathmore.fingerprintapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class ActivityFour extends AppCompatActivity {

    EditText txtEmail, txtFullname, txtDateofbirth, txtPhone, txtPassword, txtCourse;
    Button btnregister;
    CheckBox checkboxGenderMale, checkBoxGenderFemale;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String Gender = "";
    FirebaseAuth firebaseAuth;
    Calendar myCalendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        getSupportActionBar().setTitle("Activity Four");


        txtCourse= (EditText) findViewById(R.id.Course_edittext);
        txtEmail = (EditText) findViewById(R.id.email_edittext);
        txtFullname = (EditText) findViewById(R.id.fullname_edittext);
        txtDateofbirth = (EditText) findViewById(R.id.date_of_birth);
        txtPhone = (EditText) findViewById(R.id.phone_edittext);
        txtPassword = (EditText) findViewById(R.id.enterpass_edittext);
        btnregister = (Button) findViewById(R.id.register_button);
        checkBoxGenderFemale = (CheckBox) findViewById(R.id.female_checkbox);
        checkboxGenderMale = (CheckBox) findViewById(R.id.male_checkbox);

        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        firebaseAuth = FirebaseAuth.getInstance();


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String Email = txtEmail.getText().toString();
                final String Fullname = txtFullname.getText().toString();
                final String DateofBirth = txtDateofbirth.getText().toString();
                final String Phone = txtPhone.getText().toString();
                final String Password = txtPassword.getText().toString();
                final String Course = txtCourse.getText().toString();

                if (checkBoxGenderFemale.isChecked()) {

                    Gender = "Female";

                }

                if (checkboxGenderMale.isChecked()) {

                    Gender = "Male";

                }


                if (TextUtils.isEmpty(Email)) {

                    Toast.makeText(ActivityFour.this, "Please Enter Email", Toast.LENGTH_SHORT).show();

                }

                if (TextUtils.isEmpty(Password)) {

                    Toast.makeText(ActivityFour.this, "Please Enter Password", Toast.LENGTH_SHORT).show();

                }

                if (TextUtils.isEmpty(Fullname)) {

                    Toast.makeText(ActivityFour.this, "Please Enter Fullname", Toast.LENGTH_SHORT).show();

                }

                if (TextUtils.isEmpty(DateofBirth)) {

                    Toast.makeText(ActivityFour.this, "Please Enter Date of Birth", Toast.LENGTH_SHORT).show();

                }

                if (TextUtils.isEmpty(Phone)) {

                    Toast.makeText(ActivityFour.this, "Please Enter Phone", Toast.LENGTH_SHORT).show();

                }

                if (TextUtils.isEmpty(Course)) {

                    Toast.makeText(ActivityFour.this, "Please Enter Course", Toast.LENGTH_SHORT).show();

                }


                firebaseAuth.createUserWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(ActivityFour.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    user information;
                                    information = new user(


                                            Fullname,
                                            Email,
                                            Gender,
                                            DateofBirth,
                                            Phone,
                                            Course


                                    );


                                    FirebaseDatabase.getInstance().getReference("user")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            Toast.makeText(ActivityFour.this, "Registration Complete", Toast.LENGTH_SHORT).show();

                                        }
                                    });


                                } else {

                                }

                                // ...
                            }
                        });


            }
        });


        final Calendar myCalendar = Calendar.getInstance();

        final EditText txtDateofbirth = (EditText) findViewById(R.id.date_of_birth);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        txtDateofbirth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ActivityFour.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
        private void updateLabel () {

            String myFormat = "MM/dd/yy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            txtDateofbirth.setText(sdf.format(myCalendar.getTime()));
        }

    }
