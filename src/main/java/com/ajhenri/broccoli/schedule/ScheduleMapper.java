package com.ajhenri.broccoli.schedule;

import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

public class ScheduleMapper implements RowMapper<Schedule> {
    public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setId(rs.getInt("id"));
        schedule.setMealId(rs.getInt("meal_id"));

        Timestamp startTime = rs.getTimestamp("start_time");
        Timestamp endTime = rs.getTimestamp("end_time");
        schedule.setStartTime(new Date(startTime.getTime()));
        schedule.setEndTime(new Date(endTime.getTime()));

        String colorCode = rs.getNString("color_code");
        schedule.setColorCode(colorCode.toCharArray());

        return schedule;
    }
}