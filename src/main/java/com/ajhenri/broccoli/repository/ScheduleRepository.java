package com.ajhenri.broccoli.repository;

import com.ajhenri.broccoli.domain.Schedule;
import com.ajhenri.broccoli.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

@Repository
public class ScheduleRepository implements ScheduleDAO {
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate.setDataSource(dataSource);
    }

    public List<Schedule> getSchedule(LocalDate startDate, LocalDate endDate){
        String sql = "SELECT * FROM meal_schedule " +
                "INNER JOIN meal ON meal_schedule.meal_id = meal.id " +
                "WHERE meal_schedule.start_time >= ? AND meal_schedule.end_time <= ?";

        java.sql.Date startDateSql = java.sql.Date.valueOf(startDate);
        java.sql.Date endDateSql = java.sql.Date.valueOf(endDate);

        return jdbcTemplate.query(sql, new Object[]{startDateSql, endDateSql},
                new ScheduleMapper());
    }

    public boolean create(int mealId, Date startTime, Date endTime, char[] colorCode){
        String sql = "INSERT INTO meal_schedule (meal_id, start_time, end_time, color_code) " +
                "VALUES (?, ?, ?, ?)";

        Timestamp startTimestamp = new Timestamp(startTime.getTime());
        Timestamp endTimestamp = new Timestamp(endTime.getTime());

        int rows = jdbcTemplate.update(sql, mealId, startTimestamp, endTimestamp, new String(colorCode));
        return rows > 0;
    }

    public boolean update(int id, int mealId, Date startTime, Date endTime, char[] colorCode){
        String sql = "UPDATE meal_schedule SET meal_id = ?, start_time = ?, end_time = ?, " +
                "color_code = ? WHERE id = ?";

        Timestamp startTimestamp = new Timestamp(startTime.getTime());
        Timestamp endTimestamp = new Timestamp(endTime.getTime());

        int rows = jdbcTemplate.update(sql, id, mealId, startTimestamp, endTimestamp, new String(colorCode));
        return rows > 0;
    }

    public boolean delete(int id){
        String sql = "DELETE FROM meal_schedule WHERE id = ?";

        int rows = jdbcTemplate.update(sql, id);
        return rows > 0;
    }
}
