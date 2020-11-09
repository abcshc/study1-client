package com.study.lottoclient.web.request;

import com.study.lottoclient.service.result.GameResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SetGameResultRequest {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private String createDate;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public GameResult convertGameResult() {
        return new GameResult(winningNumbers, bonusNumber, LocalDate.parse(createDate, DateTimeFormatter.ISO_DATE));
    }
}
