package com.example.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {

    private String title;

    private long runningTime;

    private long netPrice; // 정가

    private DiscountPolicy discountPolicy;

    public long applyDiscountPolicy(Screening screening, int audienceCount) {
        long price = netPrice;
        if(discountPolicy != null) {
            price = discountPolicy.calculate(screening);
        }
        return price * audienceCount;
    }
}
