package com.example.insurancesystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class CarInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String carName;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String carModel;

}
