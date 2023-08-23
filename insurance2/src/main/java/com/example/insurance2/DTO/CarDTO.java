package com.example.insurance2.DTO;

import com.example.insurance2.Model.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CarDTO {

    private Integer order_Id;
    //@NotEmpty(message = "should not be empty")
    //@Column(columnDefinition = "varchar(20) not null")
    private String carName;
    //@NotNull(message = "should not be empty")
    //@Column(columnDefinition = "int not null")
    private Integer carModel;
    //@NotNull(message = "should not be empty")
    //@Column(columnDefinition = "int not null unique")
    private Integer serialNumber;

    private User user;

}
