package com.study.lottoclient.service.result;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<Integer> winningNumbers;
    private Integer bonus;
    private LocalDate resultDate;

    public GameResult(List<Integer> winningNumbers, Integer bonus, LocalDate resultDate) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
        this.resultDate = resultDate;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonus() {
        return bonus;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(winningNumbers, that.winningNumbers) &&
                Objects.equals(bonus, that.bonus) &&
                Objects.equals(resultDate, that.resultDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonus, resultDate);
    }
}
