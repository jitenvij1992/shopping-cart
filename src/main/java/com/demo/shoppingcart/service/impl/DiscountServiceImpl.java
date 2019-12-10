package com.demo.shoppingcart.service.impl;


import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shoppingcart.dao.DiscountRepository;
import com.demo.shoppingcart.exception.DiscountNotFoundException;
import com.demo.shoppingcart.model.Discount;
import com.demo.shoppingcart.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    @Override
    public void addDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void deleteDiscount(BigDecimal discount) {
        Optional<Discount> byDiscount = discountRepository.findByDiscount(discount);
        byDiscount.ifPresentOrElse(d -> discountRepository.delete(d),
                () -> {
                    throw new DiscountNotFoundException("Discount Not found");
                });
    }
}
