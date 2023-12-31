package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
import com.example.insurance2.Model.Insurance;
import com.example.insurance2.Model.User;
import com.example.insurance2.Repository.InsurancePackageRepository;
import com.example.insurance2.Repository.InsuranceRepository;
import com.example.insurance2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final InsurancePackageRepository insurancePackageRepository;
    private final UserRepository userRepository;
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

    public void addDescription(Integer insuranceId){
        Insurance insurance1 = insuranceRepository.findInsuranceById(insuranceId);
        if(insurance1 == null){
            throw new ApiException("Insurance not found");
        }
        else if (insurance1.getName().equals("tawuniya")) {
            insurance1.setDescription(" Tawuniya Insurance Company provides two types of vehicle insurance : third party insurance, comprehensive insurance.We have Good Price .");
            insuranceRepository.save(insurance1);
        } else if (insurance1.getName().equals("salama")) {
            insurance1.setDescription(" Salama Insurance Company provides two types of vehicle insurance : third party insurance, comprehensive insurance.We have Good Price .");
            insuranceRepository.save(insurance1);
        }
        else {
            insurance1.setDescription(" Walaa Insurance Company provides two types of vehicle insurance : third party insurance, comprehensive insurance.We have Good Price .");
            insuranceRepository.save(insurance1);
        }
    }

    public void assingInsuranceToUser(Integer userId, Integer insuranceId){
        User user = userRepository.findUserById(userId);
        Insurance insurance = insuranceRepository.findInsuranceById(insuranceId);
        if(insurance == null || user == null){
            throw new ApiException("Insurance or user not found");
        }
        insurance.setUser(user);
        insuranceRepository.save(insurance);
    }


}
