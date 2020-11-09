package com.study.lottoclient.service.result;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    private LocalDate createDate;
    
    public GameResult(List<Integer> winningNumbers, Integer bonusNumber, LocalDate createDate) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(winningNumbers, that.winningNumbers) &&
                Objects.equals(bonusNumber, that.bonusNumber) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber, createDate);
    }
}
