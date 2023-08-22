package com.example.insurancesystem.Controller;

import com.example.insurancesystem.Api.ApiResponse;
import com.example.insurancesystem.Model.Insurance;
import com.example.insurancesystem.Service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/insurances")
@RequiredArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;

    @GetMapping("/")
    public ResponseEntity getInsurances() {
        return ResponseEntity.status(HttpStatus.OK).body(insuranceService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addInsurance(Insurance insurance) {
        insuranceService.addInsurance(insurance);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Insurance added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateInsurance(Integer id, Insurance insurance) {
        insuranceService.updateInsurance(id, insurance);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Insurance updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteInsurance(Integer id) {
        insuranceService.removeInsurance(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Insurance deleted"));
    }

    @GetMapping("/search/{")
    public ResponseEntity searchByInsuranceName(String name) {
        return ResponseEntity.status(HttpStatus.OK).body(insuranceService.findInsuranceByName(name));
    }
}
