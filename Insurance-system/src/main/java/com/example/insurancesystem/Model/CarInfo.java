package com.example.insurancesystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    // hello
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String carModel;
    @NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String carName;
    @NotNull(message = "should not be null")
    @Column(columnDefinition = "int not null")
    private Integer serialNumber;
}
