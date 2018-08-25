package com.ajhenri.broccoli.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Schedule {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private int mealId;
    @Getter @Setter
    private Date startTime;
    @Getter @Setter
    private Date endTime;
    @Getter @Setter
    private char[] colorCode;

    public Schedule(){}

    public Schedule(int id, int mealId, Date startTime, Date endTime, char[] colorCode){
        this.id = id;
        this.mealId = mealId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.colorCode = colorCode;
    }
}
