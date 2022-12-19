package com.mrtb.entities;

import com.mrtb.valueObjects.UserObject;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id @GeneratedValue
    @Column
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String username;


    @Column
    private String password;

    @UpdateTimestamp
    @Column(name = "update_on")
    private Date updateOn;

    @CreationTimestamp
    @Column(name = "create_on")
    private Date createOn;

    @Column
    private String email;

    public static User of(UserObject userObject){
        return User.builder()
                .id(userObject.getId())
                .firstName(userObject.getFirstName())
                .lastName(userObject.getLastName())
                .username(userObject.getUsername())
                .password(userObject.getPassword())
                .email(userObject.getEmail())
                .build();
    }

}

