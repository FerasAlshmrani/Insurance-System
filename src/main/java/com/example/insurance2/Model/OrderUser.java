package com.example.insurance2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //@NotEmpty(message = "endDate should be not empty")
    private Date endDate;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
    @PrimaryKeyJoinColumn
    private Car car;

    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(15) NOT NULL check(insurance_name = 'tawuniya' or insurance_name = 'salama' or insurance_name = 'walaa') ")
    private String insurance_name;

    private Double insurancePrice;
    private String duration = "Year";
    @NotEmpty(message = "Should be not empty")
    @Column(columnDefinition = "varchar(50) NOT NULL check(insurancetype = 'Third party insurance' or insurancetype = 'full insurance')")
    private String insurancetype;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "insurance_package_id" , referencedColumnName = "id")
    @JsonIgnore
    private InsurancePackage insurance_package;



}
