package com.study.lottoclient.service.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameResultServiceImplTest {
    private GameResultService gameResultService;
    private GameResultRepository repository = mock(GameResultRepository.class);

    @BeforeEach
    void setup() {
        gameResultService = new GameResultServiceImpl(repository);
    }

    @Test
    void test_setGameResult_success() {
        when(repository.save(1L, new GameResult(List.of(1, 2, 3, 4, 5, 6), 7, LocalDate.of(2020, 11, 8))))
                .thenReturn(1L);

        assertEquals(1L, gameResultService.setGameResult(1L, new GameResult(List.of(1, 2, 3, 4, 5, 6), 7, LocalDate.of(2020, 11, 8))));
    }

    @Test
    void test_findByRound_success() {
        when(repository.findByRound(1L)).thenReturn(Optional.of(new GameResult(List.of(1, 2, 3, 4, 5, 6), 7, LocalDate.of(2020, 11, 22))));
        GameResult gameResult = gameResultService.findByRound(1L).get();
        assertEquals(LocalDate.of(2020, 11, 22), gameResult.getResultDate());
        assertEquals(List.of(1, 2, 3, 4, 5, 6), gameResult.getWinningNumbers());
        assertEquals(7, gameResult.getBonus());
    }
}