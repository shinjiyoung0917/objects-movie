package com.example.movie.domain;

public class SequenceCondition implements DiscountCondition {

    private long sequence;

    public SequenceCondition(long sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isCorrespondedTo(Screening screening) {
        // 순번에 해당되는지 확인
        return screening.isSameSequence(sequence);
    }
}
