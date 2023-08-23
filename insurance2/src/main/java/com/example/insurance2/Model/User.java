package com.example.insurance2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
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

/*    @Column(columnDefinition = "varchar(15) not null check(role IN ('person', 'company'))")
    @NotEmpty(message = "Role Not Empty")*/
    private String role = "person";



    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Car> car;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<OrderUser> orderUserSet;
}