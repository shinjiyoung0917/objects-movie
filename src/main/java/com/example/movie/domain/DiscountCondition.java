package com.example.movie.domain;

// 다수의 할인 조건 지정 가능
public interface DiscountCondition {

    boolean isCorrespondedTo(Screening screening);
}
