package com.demo.shoppingcart.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.shoppingcart.dao.DiscountRepository;
import com.demo.shoppingcart.model.Discount;
import com.demo.shoppingcart.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    DiscountRepository discountRepository;

    @Override
    public BigDecimal getPrice(BigDecimal price) {
        BigDecimal discount = getDiscount(price);
        return price.subtract(calculateDiscountOnPrice(price, discount));
    }

    private BigDecimal calculateDiscountOnPrice(BigDecimal price, BigDecimal discount) {
        return  price.multiply(discount).divide(new BigDecimal(100));
    }

    private BigDecimal getDiscount(BigDecimal price) {
        Optional<Discount> discountRange = discountRepository.getDiscountRange(price);
        if(discountRange.isPresent()) {
            return discountRange.get().getDiscount();
        } else {
            return BigDecimal.ZERO;
        }
    }
}
