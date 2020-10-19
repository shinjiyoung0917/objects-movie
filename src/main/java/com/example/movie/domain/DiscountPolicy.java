package com.example.movie.domain;

import java.util.List;

// 하나의 할인 정책만 지정 가능
public abstract class DiscountPolicy {

    private List<DiscountCondition> discountConditions;

    public DiscountPolicy(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    abstract long discount(long price);

    public long calculate(Screening screening) {
        long price = screening.getMovie().getNetPrice();
        boolean corresponded = discountConditions.stream()
                .anyMatch(discountCondition -> discountCondition.isCorrespondedTo(screening));
        return corresponded ? discount(price) : price;
    }
}
