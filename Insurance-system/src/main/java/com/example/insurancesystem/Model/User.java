package com.example.insurancesystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name Not Empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;
    @NotEmpty(message = "Phone Number Not Empty")
    @Column(columnDefinition = "int not null")
    private Integer phonenumber;

    @Column(columnDefinition = "varchar(15) not null check(role='person' or role='company')")
    @NotEmpty(message = "Role Not Empty")
    private String role;

    @ManyToOne
    @JoinColumn(name = "insurance_id" , referencedColumnName = "id")
    @JsonIgnore
    private Insurance insurance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Order> orderSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<CarInfo> carInfoSet;



}
