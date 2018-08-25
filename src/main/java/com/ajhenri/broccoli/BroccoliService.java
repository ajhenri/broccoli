package com.ajhenri.broccoli;

import com.ajhenri.broccoli.meal.Meal;
import com.ajhenri.broccoli.schedule.Schedule;
import com.ajhenri.broccoli.ingredient.Ingredient;

import com.ajhenri.broccoli.meal.MealRepository;
import com.ajhenri.broccoli.schedule.ScheduleRepository;
import com.ajhenri.broccoli.ingredient.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BroccoliService {

    @Autowired
    private MealRepository mealRepository;
    private ScheduleRepository scheduleRepository;
    private IngredientRepository ingredientRepository;

    public List<Meal> getAllMeals(){
        return mealRepository.getAllMeals();
    }

    public List<Ingredient> getAllIngredients() { return ingredientRepository.getAllIngredients(); }

    public Meal getMeal(int id){
        return mealRepository.getMeal(id);
    }

    public void addMeal(Meal meal){
        mealRepository.create(meal.getName(), meal.getPrepTime(), meal.getCookTime(), meal.getEatTime());
    }

    public void addScheduleItem(Schedule schedule){
        scheduleRepository.create(schedule.getMealId(), schedule.getStartTime(), schedule.getEndTime(),
                schedule.getColorCode());
    }

    public List<Schedule> getSchedule(LocalDate startDate, LocalDate endDate){
        return scheduleRepository.getSchedule(startDate, endDate);
    }
}
