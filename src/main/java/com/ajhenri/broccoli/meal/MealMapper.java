package com.ajhenri.broccoli.meal;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MealMapper implements RowMapper<Meal> {
    public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Meal meal = new Meal();
        meal.setId(rs.getInt("id"));
        meal.setName(rs.getString("name"));
        meal.setPrepTime(rs.getInt("prep_time"));
        meal.setCookTime(rs.getInt("cook_time"));
        meal.setEatTime(rs.getInt("eat_time"));

        return meal;
    }
}
