package com.example.insurancesystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class InsurancePackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Should be not null")
    private Integer InsurancePrice;

    private String duration = "Year";

    private String Insurancetype;

    @ManyToOne
    @JoinColumn(name = "insurance_id" , referencedColumnName = "id")
    @JsonIgnore
    private Insurance insurance;
    @ManyToOne
    @JoinColumn(name = "order_id" , referencedColumnName = "id")
    @JsonIgnore
    private Order order;
}
