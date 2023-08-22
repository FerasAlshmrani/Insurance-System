package com.example.insurancesystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "insurance_id" , referencedColumnName = "id")
    @JsonIgnore
    private Insurance insurance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Order> orderSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<CarInfo> carInfoSet;



}
