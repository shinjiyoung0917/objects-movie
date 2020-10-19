package com.example.movie.domain;

import java.util.List;

public class PriceDiscountPolicy extends DiscountPolicy {

    private long amount;

    public PriceDiscountPolicy(List<DiscountCondition> discountConditions, long amount) {
        super(discountConditions);
        this.amount = amount;
    }

    @Override
    public long discount(long price) {
        return price - amount;
    }
}
