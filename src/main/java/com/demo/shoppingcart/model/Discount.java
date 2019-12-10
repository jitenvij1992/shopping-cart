package com.demo.shoppingcart.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal startRange;
    private BigDecimal endRange;
    private BigDecimal discount;

    public Discount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getStartRange() {
        return startRange;
    }

    public void setStartRange(BigDecimal startRange) {
        this.startRange = startRange;
    }

    public BigDecimal getEndRange() {
        return endRange;
    }

    public void setEndRange(BigDecimal endRange) {
        this.endRange = endRange;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Discount discount1 = (Discount) o;
        return id == discount1.id &&
                Objects.equals(startRange, discount1.startRange) &&
                Objects.equals(endRange, discount1.endRange) &&
                Objects.equals(discount, discount1.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startRange, endRange, discount);
    }
}
