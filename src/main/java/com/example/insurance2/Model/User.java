package com.example.insurance2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name Not Empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;
    @NotNull(message = "Phone Number Not Empty")
    @Column(columnDefinition = "int not null")
    private Integer phonenumber;

   @Column(columnDefinition = "varchar(15) not null")
    @NotEmpty(message = "Role Not Empty")
    private String role ;

   @Column(columnDefinition = "double")
   private Double balance;

   @NotNull(message = "Not Null")
    @Column(columnDefinition = "int not null")
   private Integer carQuntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Car> car;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<OrderUser> orderUserSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Insurance> insuranceSet;
}
