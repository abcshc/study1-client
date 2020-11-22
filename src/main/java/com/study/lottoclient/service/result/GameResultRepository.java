package com.study.lottoclient.service.result;

import java.util.Optional;

public interface GameResultRepository {
    Long save(Long round, GameResult gameResult);

    Optional<GameResult> findByRound(Long round);
}
