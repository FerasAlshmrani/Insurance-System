package com.example.insurance2.Model;

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
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Should be not empty")
    @Column(columnDefinition = "varchar(15) NOT NULL check(name = 'tawuniya' or name = 'salama' or name = 'walaa')")
    private String name;
    @Column(columnDefinition = "varchar(200)")
    private String description;

    @NotNull(message = "Should be not null")
    @Column(columnDefinition = "int not null")
    private Integer insuranceNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="insurance")
    private Set<InsurancePackage> insurancePackages;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
