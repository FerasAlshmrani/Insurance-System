package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
import com.example.insurance2.Model.Coupon;
import com.example.insurance2.Repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponSerivce {

    private final CouponRepository couponreposetry;
    public List<Coupon> getCoupons() {
        return couponreposetry.findAll();
    }

    public void addCoupon(Coupon coupon){
        couponreposetry.save(coupon);
    }

    public void removeCoupon(Integer id){
        Coupon coupon = couponreposetry.findCouponById(id);
        if(coupon == null){
            throw  new ApiException("Coupon not found");
        }
        couponreposetry.deleteById(id);
    }


    public void update (Integer id,Coupon coupon){
        Coupon coupons = couponreposetry.findCouponById(id);
        if(coupons == null){
            throw  new ApiException("Coupon not found");
        }
        coupons.setStatus(coupon.getStatus());
        coupons.setCouponPrice(coupon.getCouponPrice());
    }

    public void endCoupons (Integer id){
        Coupon coupons = couponreposetry.findCouponById(id);
        if(coupons == null){
            throw  new ApiException("Coupon not found");
        }
        coupons.setStatus("used");
        couponreposetry.save(coupons);
    }
}
