package com.ajhenri.broccoli.repository;

import com.ajhenri.broccoli.domain.Meal;

import java.util.List;
import javax.sql.DataSource;

public interface MealDAO {
    public void setDataSource(DataSource ds);

    public Meal getMeal(int id);

    public List<Meal> getAllMeals();

    public void create(String name, int prepTime, int cookTime, int eatTime);

    public void update(int id, String name, int prepTime, int cookTime, int eatTime);

    public void delete(int id);
}
