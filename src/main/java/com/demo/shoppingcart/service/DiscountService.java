package com.demo.shoppingcart.service;

import java.math.BigDecimal;

import com.demo.shoppingcart.model.Discount;

public interface DiscountService {

    void addDiscount(Discount discount);

    void deleteDiscount(BigDecimal discount);
}
