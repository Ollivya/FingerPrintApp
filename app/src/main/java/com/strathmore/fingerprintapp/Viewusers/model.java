package com.strathmore.fingerprintapp.Viewusers;

public class model {

String DateofBirth, Email, Fullname, Gender, Phone, Course;

     model() {





}


    public model(String dateofBirth, String email, String fullName, String gender, String phone, String course) {
        DateofBirth = dateofBirth;
        Email = email;
        Fullname = fullName;
        Gender = gender;
        Phone = phone;
        Course = course;

    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullName() {
        return Fullname;
    }

    public void setFullName(String fullName) {
        Fullname = fullName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
