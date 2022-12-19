package com.mrtb.valueObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrtb.entities.User;
import lombok.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class UserObject {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private String firstName;

    private String lastName;

    @NotBlank(message = "{error.usernameBlank}")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,}$",message = "{error.usernamePattern}")
    private String username;

    @NotBlank(message = "{error.passwordRequired}")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,}$"
            ,message = "")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "{error.emailRequired}")
    @Email
    private String email;

    public static UserObject of(User user){
        return UserObject.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

}
