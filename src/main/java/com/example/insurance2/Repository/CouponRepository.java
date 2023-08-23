package com.example.insurance2.Repository;

import com.example.insurance2.Model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    Coupon findCouponById(Integer id);

    Coupon findCouponByCouponCode(String coupon);

}
