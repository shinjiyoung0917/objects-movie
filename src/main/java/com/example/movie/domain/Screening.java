package com.example.movie.domain;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class Screening {

    private Movie movie;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;

    private long sequence;

    public Screening(Movie movie, LocalDateTime startDatetime, long sequence) {
        this.movie = movie;
        this.startDatetime = startDatetime;
        endDatetime = startDatetime.plusHours(movie.getRunningTime());
        this.sequence = sequence;
    }

    public boolean isSameSequence(long sequence) {
        return this.sequence == sequence;
    }

    private boolean isAfter(LocalTime startTime) {
        LocalTime time = startDatetime.toLocalTime();
        return time.isAfter(startTime) || time.equals(startTime);
    }

    private boolean isBefore(LocalTime endTime) {
        LocalTime time = endDatetime.toLocalTime();
        return time.isBefore(endTime) || time.equals(endTime);
    }

    public boolean isIncludedInPeriod(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        return startDatetime.getDayOfWeek().equals(dayOfWeek) && isAfter(startTime) && isBefore(endTime);
    }

    public Reservation reserve(int audienceCount) {
        return new Reservation(this, audienceCount, movie.applyDiscountPolicy(this, audienceCount));
    }
}
