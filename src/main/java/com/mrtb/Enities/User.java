package com.mrtb.Enities;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Timestamp signup_time;
    public User(String name){
        this.name = name;
        this.signup_time =  new Timestamp(System.currentTimeMillis());
    }


}
