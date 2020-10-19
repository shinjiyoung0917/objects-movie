package com.example.movie.domain;

import java.util.List;

public class RateDiscountPolicy extends DiscountPolicy {

    private double rate;

    public RateDiscountPolicy(List<DiscountCondition> discountConditions, double rate) {
        super(discountConditions);
        this.rate = rate;
    }

    @Override
    public long discount(long price) {
        double discountRate = 1 - rate / 100;
        return  (int) Math.ceil(price * discountRate);
    }
}
