package com.mrtb.Enities;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
@Builder
public class User {

    private long id;

    private String firstName;

    private String lastName;

    @NotBlank(message = "username is required!")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,}$",message = "username must be at least 3 characters('a-z','A-Z','0-9','-','_')")
    private String username;

    @NotBlank(message = "password is required!")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,}$"
            ,message = "password must be at least 8 characters and contains " +
            "a-z,A-Z,0-9")
    private String password;


    private Timestamp updateOn;

    private Timestamp createOn;

    @NotBlank(message = "email is required!")
    @Email
    private String email;


    @Override
    public String toString(){
        return String.format("");
    }
}
