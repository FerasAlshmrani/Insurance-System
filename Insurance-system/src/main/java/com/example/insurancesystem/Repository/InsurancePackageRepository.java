package com.example.insurancesystem.Repository;

import com.example.insurancesystem.Model.InsurancePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePackageRepository extends JpaRepository<InsurancePackage, Integer> {
}
