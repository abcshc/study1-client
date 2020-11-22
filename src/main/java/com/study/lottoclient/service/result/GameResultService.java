package com.study.lottoclient.service.result;

import java.util.Optional;

public interface GameResultService {
    Long setGameResult(Long round, GameResult convertGameResult);

    Optional<GameResult> findByRound(Long round);
}
