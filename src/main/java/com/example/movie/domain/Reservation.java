package com.example.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Reservation {

    private Screening screening;

    private int audienceCount;

    private long paymentAmount;

}
