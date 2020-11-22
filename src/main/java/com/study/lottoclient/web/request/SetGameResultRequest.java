package com.study.lottoclient.web.request;

import com.study.lottoclient.service.result.GameResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SetGameResultRequest {
    private Long round;
    private List<Integer> winningNumbers;
    private int bonus;
    private String createDate;

    public Long getRound() {
        return round;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public GameResult convertGameResult() {
        return new GameResult(winningNumbers, bonus, LocalDate.parse(createDate, DateTimeFormatter.ISO_DATE));
    }
}
