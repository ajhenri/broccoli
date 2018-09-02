package com.ajhenri.broccoli.repository;

import com.ajhenri.broccoli.domain.Schedule;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

public interface ScheduleDAO {
    public void setDataSource(DataSource ds);

    public List<Schedule> getSchedule(LocalDate startDate, LocalDate endDate);

    public boolean create(int mealId, Date startTime, Date endTime, char[] colorCode);

    public boolean update(int id, int mealId, Date startTime, Date endTime, char[] colorCode);

    public boolean delete(int id);
}