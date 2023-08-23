package com.example.insurance2.Repository;

import com.example.insurance2.Model.InsurancePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsurancePackageRepository extends JpaRepository<InsurancePackage,Integer> {
    InsurancePackage findInsurancePackageById(Integer id);
    List<InsurancePackage> findInsurancePackageByInsurancePriceIsLessThan(Double insurancePrice);

    List<InsurancePackage>findInsurancePackageByInsurancetype(String insuranceType);



}
