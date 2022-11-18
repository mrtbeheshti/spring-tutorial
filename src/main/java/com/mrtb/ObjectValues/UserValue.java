package com.mrtb.ObjectValues;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserValue {
    @Id @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @UpdateTimestamp
    private Timestamp updateOn;

    @CreationTimestamp
    private Timestamp createOn;

    private String email;

}

