package com.example.insurancesystem.Service;

import com.example.insurancesystem.Api.ApiException;
import com.example.insurancesystem.Model.Insurance;
import com.example.insurancesystem.Repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    public List<Insurance> getAll(){
        return insuranceRepository.findAll();
    }

    public void addInsurance(Insurance insurance){
        insuranceRepository.save(insurance);
    }

    public void removeInsurance(Integer id){
        Insurance insurances = insuranceRepository.findInsuranceById(id);
       if(insurances == null){
           throw new ApiException("Insurance not found");
       }
       insuranceRepository.delete(insurances);
    }

    public void updateInsurance(Integer id, Insurance insurance){
        Insurance insurances = insuranceRepository.findInsuranceById(id);
        if(insurances == null){
            throw new ApiException("Insurance not found");
        }
        insurances.setInsuranceNumber(insurance.getInsuranceNumber());
        insurances.setName(insurance.getName());
        insurances.setDescription(insurance.getDescription());
        insuranceRepository.save(insurances);
    }


    public Insurance findInsuranceByName(String name){
        Insurance insurance1 = insuranceRepository.findInsuranceByName(name);
        if(insurance1 == null){
            throw new ApiException("Insurance not found");
        }
        return insurance1;
    }

}
