package com.mrtb.Enities;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@Builder
public class UserUpdate {
    private String firstName;
    private String lastName;

    @NotBlank(message = "username is required!")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,}$",message = "username must be at least 3 characters('a-z','A-Z','0-9','-','_')")
    private String username;
}
