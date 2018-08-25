package com.ajhenri.broccoli;

import com.ajhenri.broccoli.meal.Meal;
import com.ajhenri.broccoli.schedule.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BroccoliController {

    @Autowired
    private BroccoliService broccoliService;

    @RequestMapping("/meals")
    public List<Meal> getAllMeals(){
        return broccoliService.getAllMeals();
    }

    @RequestMapping("/meals/{id}")
    public Meal getMeal(@PathVariable int id){
        return broccoliService.getMeal(id);
    }

    @RequestMapping(value="/meals", method = RequestMethod.POST)
    public void addMeal(@RequestBody Meal meal){
        broccoliService.addMeal(meal);
    }

    @RequestMapping(value="/schedule", params = {"startDate", "endDate"})
    public List<Schedule> getSchedule(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate
    ) {
        return broccoliService.getSchedule(startDate, endDate);
    }
}
