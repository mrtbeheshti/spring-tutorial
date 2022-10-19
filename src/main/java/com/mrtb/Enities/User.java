package com.mrtb.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    @NotBlank(message = "username is required!")
    @Pattern(regexp = "^[a-z A-Z 0-9 \\_ \\-]{3,}$")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "password is required!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @UpdateTimestamp
    private Timestamp updateOn;

    @CreationTimestamp
    private Timestamp createOn;

    @NotBlank(message = "email is required!")
    @Email
    private String email;

    @JsonIgnore
    public long getId() {
        return this.id;
    }
}
