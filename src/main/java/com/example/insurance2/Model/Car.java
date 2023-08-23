package com.example.insurance2.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@NotEmpty(message = "should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String carName;
    //@NotNull(message = "should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer carModel;
    //@NotNull(message = "should not be empty")
    @Column(columnDefinition = "int not null unique")
    private Integer serialNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private OrderUser order;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

}
