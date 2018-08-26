package com.ajhenri.broccoli.schedule;

import com.ajhenri.broccoli.utilities.serializers.DateDeserializer;
import com.ajhenri.broccoli.utilities.serializers.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Schedule {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private int mealId;
    @Getter @Setter
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date startTime;
    @Getter @Setter
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
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
