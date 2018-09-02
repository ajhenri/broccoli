package com.ajhenri.broccoli;

import com.ajhenri.broccoli.domain.Meal;
import com.ajhenri.broccoli.domain.Schedule;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.ajhenri.broccoli.utilities.Constants.GLOBAL_DATE_FORMAT;

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

    @RequestMapping(value = "/meals", method = RequestMethod.POST)
    public void addMeal(@RequestBody Meal meal){
        broccoliService.addMeal(meal);
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET, params = {"startDate", "endDate"})
    public List<Schedule> getSchedule(
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GLOBAL_DATE_FORMAT);

        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        return broccoliService.getSchedule(startDate, endDate);
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public void addScheduleItem(@RequestBody Schedule schedule){
        broccoliService.addScheduleItem(schedule);
    }
}
