package com.demo.shoppingcart.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shoppingcart.model.Discount;
import com.demo.shoppingcart.service.DiscountService;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDiscount(@RequestBody Discount discount) {
        discountService.addDiscount(discount);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }

    @DeleteMapping(value = "/{discount}")
    public ResponseEntity<String> deleteDiscount(@PathVariable BigDecimal discount) {
        discountService.deleteDiscount(discount);
        return ResponseEntity.ok().body("Successfully deleted");
    }
}
