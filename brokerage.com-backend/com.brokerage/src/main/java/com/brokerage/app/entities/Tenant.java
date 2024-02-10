package com.brokerage.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tenant_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Tenant{


    @Column(length = 50,name = "first_name")
    private String firstName;

    @Column(length = 50,name = "last_name")
    private String lastName;

    @Id
    @Column(name = "mobile_number", unique = true)
    private Long mobileNumber;

    @Column(length=50,name="email")
    private String emailId;

    @Column(length=50,name="password")
    private String password;

}
