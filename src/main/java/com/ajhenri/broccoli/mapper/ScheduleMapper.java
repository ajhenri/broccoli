package com.ajhenri.broccoli.mapper;

import com.ajhenri.broccoli.domain.Meal;
import com.ajhenri.broccoli.domain.Schedule;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

public class ScheduleMapper implements RowMapper<Schedule> {
    public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setId(rs.getInt("id"));

        int mealId = rs.getInt("meal_id");
        schedule.setMealId(mealId);

        Timestamp startTime = rs.getTimestamp("start_time");
        Timestamp endTime = rs.getTimestamp("end_time");
        schedule.setStartTime(new Date(startTime.getTime()));
        schedule.setEndTime(new Date(endTime.getTime()));

        String colorCode = rs.getString("color_code");
        schedule.setColorCode(colorCode.toCharArray());

        Meal meal = new Meal();
        meal.setId(mealId);
        meal.setName(rs.getString("name"));
        meal.setPrepTime(rs.getInt("prep_time"));
        meal.setCookTime(rs.getInt("cook_time"));
        meal.setEatTime(rs.getInt("eat_time"));

        schedule.setMeal(meal);

        return schedule;
    }
}