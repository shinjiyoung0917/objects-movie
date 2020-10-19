package com.example.movie;

import com.example.movie.domain.*;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieServiceTest {

    @Test
    public void 테스트() {
        List<DiscountCondition> discountConditions1 = Arrays.asList(
                new SequenceCondition(0),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(18, 0), LocalTime.of(21, 0))
        );
        DiscountPolicy discountPolicy1 = new PriceDiscountPolicy(discountConditions1, 800);
        Movie movie1 = new Movie("아바타", 110, 10000, discountPolicy1);

        List<DiscountCondition> discountConditions2 = Arrays.asList(
                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(17, 0)),
                new SequenceCondition(2),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(14, 0))
        );
        DiscountPolicy discountPolicy2 = new RateDiscountPolicy(discountConditions2, 10.0);
        Movie movie2 = new Movie("타이타닉", 123, 11000, discountPolicy2);


        Movie movie3 = new Movie("스타워즈:깨어난 포스", 130, 10000, null);

        Screening screening = new Screening(movie3, LocalDateTime.of(2020, 10, 15, 20, 0), 2);
        Reservation reservation = screening.reserve(3);

        assertThat(reservation.getPaymentAmount()).isEqualTo(30000);
    }
}
