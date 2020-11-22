package com.study.lottoclient.service.result;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameResultServiceImpl implements GameResultService {
    private final GameResultRepository gameResultRepository;

    public GameResultServiceImpl(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    @Override
    public Long setGameResult(Long round, GameResult gameResult) {
        return gameResultRepository.save(round, gameResult);
    }

    @Override
    public Optional<GameResult> findByRound(Long round) {
        return gameResultRepository.findByRound(round);
    }
}
