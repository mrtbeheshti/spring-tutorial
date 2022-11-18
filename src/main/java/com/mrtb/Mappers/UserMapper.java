package com.mrtb.Mappers;

import com.mrtb.Enities.User;
import com.mrtb.ObjectValues.UserValue;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public User userValueToUser(UserValue userValue){
        User user= User.builder()
                .id(userValue.getId())
                .firstName(userValue.getFirstName())
                .lastName(userValue.getLastName())
                .username(userValue.getUsername())
                .password(userValue.getPassword())
                .updateOn(userValue.getUpdateOn())
                .createOn(userValue.getCreateOn())
                .email(userValue.getEmail())
                .build();
        return user;
    }
    public UserValue userToUserValue(User user){
        UserValue userValue = UserValue.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .password(user.getPassword())
                .updateOn(user.getUpdateOn())
                .createOn(user.getCreateOn())
                .email(user.getEmail())
                .build();
        return userValue;
    }
    public List<User> userValuesToUsers(List<UserValue> userValues){
        return userValues.stream().map(userValue -> this.userValueToUser(userValue)).collect(Collectors.toList());
    }
}
