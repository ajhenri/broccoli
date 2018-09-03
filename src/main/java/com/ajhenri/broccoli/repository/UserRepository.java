package com.ajhenri.broccoli.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepository {
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean create(String firstName, String lastName, String username, String password){
        String sql = "INSERT INTO users (first_name, last_name, username, password) VALUES " +
                "(?, ?, ?, ?)";

        int rows = jdbcTemplate.update(sql, firstName, lastName, username, password);
        return rows > 0;
    }
}