package com.mrtb.valueObjects;

import lombok.*;

import javax.validation.constraints.Pattern;


@Data
@Builder
public class UserUpdateObject {
    private String firstName;
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,}$",message = "{error.usernamePattern}")
    private String username;
}
