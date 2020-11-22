package com.study.lottoclient.web.response;

import com.study.lottoclient.service.result.GameResult;

import java.time.LocalDate;
import java.util.List;

public class GameResultResponse {
    private Long round;
    private List<Integer> winningNumbers;
    private Integer bonus;
    private String resultDate;

    public GameResultResponse(Long round, GameResult gameResult) {
        this.round = round;
        this.bonus = gameResult.getBonus();
        this.winningNumbers = gameResult.getWinningNumbers();
        this.resultDate = gameResult.getResultDate().toString();
    }

    public Long getRound() {
        return round;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonus() {
        return bonus;
    }

    public String getResultDate() {
        return resultDate;
    }
}
