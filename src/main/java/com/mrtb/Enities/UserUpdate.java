package com.mrtb.Enities;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserUpdate {

    @NotNull
    private long id;

    private String firstName;
    private String lastName;
    private String username;
}
