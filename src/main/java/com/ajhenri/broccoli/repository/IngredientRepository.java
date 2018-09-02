package com.ajhenri.broccoli.repository;

import com.ajhenri.broccoli.domain.Ingredient;
import com.ajhenri.broccoli.mapper.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class IngredientRepository implements IngredientDAO {

    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate.setDataSource(dataSource);
    }

    public Ingredient getIngredient(int id){
        String sql = "SELECT * FROM ingredient where id = ?";
        Ingredient ingredient = jdbcTemplate.queryForObject(sql, new Object[]{id}, new IngredientMapper());

        return ingredient;
    }

    public List<Ingredient> getAllIngredients(){
        String sql = "SELECT * FROM ingredient";
        List <Ingredient> ingredients = jdbcTemplate.query(sql, new IngredientMapper());

        return ingredients;
    }

    public void create(String name){
        String sql = "INSERT INTO ingredient (name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }

    public void update(int id, String name){
        String sql = "UPDATE ingredient SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public void delete(int id){
        String sql = "DELETE FROM ingredient WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
