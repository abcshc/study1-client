package com.study.lottoclient.service.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameResultRepositoryImplTest {
    private GameResultRepository gameResultRepository;

    @BeforeEach
    void setup() {
        gameResultRepository = new GameResultRepositoryImpl();
    }

    @Test
    void test_save() {
        assertEquals(1L, gameResultRepository.save(1L, new GameResult(List.of(1, 2, 3, 4, 5, 6), 7, LocalDate.of(2020, 11, 22))));
    }

    @Test
    void test_findByRound() {
        Long round = gameResultRepository.save(1L, new GameResult(List.of(1, 2, 3, 4, 5, 6), 7, LocalDate.of(2020, 11, 22)));
        GameResult gameResult = gameResultRepository.findByRound(round).get();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), gameResult.getWinningNumbers());
        assertEquals(7, gameResult.getBonus());
        assertEquals(LocalDate.of(2020, 11, 22), gameResult.getResultDate());
    }

    @Test
    void test_findByRound_whenNoData() {
        assertTrue(gameResultRepository.findByRound(0L).isEmpty());
    }
}