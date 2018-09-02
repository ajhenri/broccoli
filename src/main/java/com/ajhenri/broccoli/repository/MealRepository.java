package com.ajhenri.broccoli.repository;

import com.ajhenri.broccoli.domain.Meal;
import com.ajhenri.broccoli.mapper.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.sql.DataSource;

@Repository
public class MealRepository implements MealDAO {

    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional(readOnly = true)
    public Meal getMeal(int id){
        String sql = "SELECT * FROM meal WHERE id = ?";
        Meal meal = jdbcTemplate.queryForObject(sql, new Object[]{id}, new MealMapper());

        return meal;
    }

    @Transactional(readOnly = true)
    public List<Meal> getAllMeals(){
        String sql = "SELECT * FROM meal";
        List<Meal> meals = jdbcTemplate.query(sql, new MealMapper());

        return meals;
    }

    public void create(String name, int prepTime, int cookTime, int eatTime){
        String sql = "INSERT INTO meal (name, prep_time, cook_time, eat_time) VALUES " +
                "(?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, prepTime, cookTime, eatTime);
    }

    public void update(int id, String name, int prepTime, int cookTime, int eatTime){
        String sql = "UPDATE meal SET name = ?, prep_time = ?, cook_time = ?, eat_time = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, name, prepTime, cookTime, eatTime, id);
    }

    public void delete(int id){
        String sql = "DELETE FROM meal WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
