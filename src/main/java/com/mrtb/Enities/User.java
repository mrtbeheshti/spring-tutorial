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
    private String message;
    private Timestamp signup_time;
    public User(String message){
        this.message = message;
        this.signup_time =  new Timestamp(System.currentTimeMillis());
    }
}
