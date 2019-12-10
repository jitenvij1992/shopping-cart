package com.demo.shoppingcart.dao;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.shoppingcart.model.Discount;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {

    Optional<Discount> findByDiscount(BigDecimal discount);

    @Query(value = "select * from (SELECT * FROM DISCOUNT where start_range < :price) where end_range >= :price",
            nativeQuery = true)
    Optional<Discount> getDiscountRange(BigDecimal price);
}
