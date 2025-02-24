package com.ajhenri.broccoli.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Boolean enabled;

    public User(){}

    public User(int id, String firstName, String lastName, String username, String password, Boolean enabled){
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }
}