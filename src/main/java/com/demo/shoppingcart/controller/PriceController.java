package com.demo.shoppingcart.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shoppingcart.service.PriceService;

@RestController
@RequestMapping("api/v1/price")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping(value = "/{price}")
    public ResponseEntity<String> getPrice(@PathVariable BigDecimal price) {
        BigDecimal updatedPrice = priceService.getPrice(price);
        return ResponseEntity.ok().body("Updated price is: "+updatedPrice);
    }
}
