package com.example.insurance2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class InsurancePackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Should be not null")
    @Column(columnDefinition = "DOUBLE not null")
    private Double insurancePrice;
    private String duration = "Year";
    @NotEmpty(message = "Should be not empty")
    @Column(columnDefinition = "varchar(50) NOT NULL check(insurancetype = 'Third party insurance' or insurancetype = 'full insurance')")
    private String insurancetype;
    @ManyToOne
    @JoinColumn(name = "insurance_id" , referencedColumnName = "id")
    @JsonIgnore
    private Insurance insurance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="insurance_package")
    private Set<OrderUser> orderUserSet;


}
