package com.strathmore.fingerprintapp.Addclass;

import java.io.Serializable;

public class Class implements Serializable {
    String lecturer;
    String room;
    String course;

    Class() {}

    public Class(String lecturer, String room, String course) {
        this.lecturer = lecturer;
        this.room = room;
        this.course = course;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getRoom() {
        return room;
    }

    public String getCourse() {
        return course;
    }
}
