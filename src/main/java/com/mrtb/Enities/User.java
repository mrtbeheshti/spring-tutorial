package com.mrtb.Enities;

import java.sql.Timestamp;

public class User {
    private String name;
    private Timestamp signup_time;
    public User(String name){
        this.name = name;
        this.signup_time =  new Timestamp(System.currentTimeMillis());
    }
}
