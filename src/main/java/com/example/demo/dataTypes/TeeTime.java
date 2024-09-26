package com.example.demo.dataTypes;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;

public class TeeTime {

    private String course;
    private Date date;
    private Time time;
    private int openSpots;

    public TeeTime(String course, Date date, Time time, int openSpots) {
        this.course = course;
        this.date = date;
        this.time = time;
        this.openSpots = openSpots;
    }

}
