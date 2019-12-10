package com.demo.shoppingcart.service.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.shoppingcart.dao.DiscountRepository;
import com.demo.shoppingcart.model.Discount;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    private static BigDecimal PRICE = new BigDecimal(9000);
    private static BigDecimal EXPECTED_PRICE = new BigDecimal(8100);

    @InjectMocks
    PriceServiceImpl priceService;

    @Mock
    DiscountRepository discountRepository;

    @Test
    void getPriceTest() {
        Discount discount = new Discount();
        discount.setDiscount(BigDecimal.TEN);
        when(discountRepository.getDiscountRange(PRICE)).thenReturn(Optional.of(discount));
        BigDecimal updatedPrice = priceService.getPrice(PRICE);
        assertEquals(EXPECTED_PRICE, updatedPrice);
    }
}