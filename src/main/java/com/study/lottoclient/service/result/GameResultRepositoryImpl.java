package com.study.lottoclient.service.result;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class GameResultRepositoryImpl implements GameResultRepository {
    private Map<Long, GameResult> gameResults = new HashMap<>();

    @Override
    public Long save(Long round, GameResult gameResult) {
        gameResults.put(round, gameResult);
        return round;
    }

    @Override
    public Optional<GameResult> findByRound(Long round) {
        return Optional.ofNullable(gameResults.get(round));
    }
}
