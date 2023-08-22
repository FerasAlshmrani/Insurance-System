package com.example.insurancesystem.Repository;

import com.example.insurancesystem.Model.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInfoRepository extends JpaRepository<CarInfo, Integer> {

    CarInfo findCarInfoById(Integer id);

    CarInfo findCarInfoBySerialNumber(Integer serialNumber);

    CarInfo findCarInfoByCarModel(Integer carModel);
}
