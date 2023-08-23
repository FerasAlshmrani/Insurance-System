package com.example.insurance2.Repository;

import com.example.insurance2.Model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    Insurance findInsuranceById(Integer id);

    Insurance findInsuranceByName(String name);
}

