package com.ajhenri.broccoli.repository;

import com.ajhenri.broccoli.domain.Ingredient;

import javax.sql.DataSource;
import java.util.List;

public interface IngredientDAO {
    public void setDataSource(DataSource ds);

    public Ingredient getIngredient(int id);

    public List<Ingredient> getAllIngredients();

    public void create(String name);

    public void update(int id, String name);

    public void delete(int id);
}
