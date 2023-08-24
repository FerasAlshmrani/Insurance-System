package com.example.insurance2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String insuranceType;
    private String role;
    private String startDate;
    private String duration= "Year";
    private String userName;
    private Integer phoneNumber;
    private Integer carQuantity;
    private Double insurancePrice;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "insurance_package_id" , referencedColumnName = "id")
    @JsonIgnore
    private InsurancePackage insurance_package;



}
