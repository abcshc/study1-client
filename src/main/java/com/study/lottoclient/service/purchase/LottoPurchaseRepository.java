package com.study.lottoclient.service.purchase;

import com.study.lottoclient.service.result.GameResult;

import java.util.List;
import java.util.Optional;

public interface LottoPurchaseRepository {
    LottoPurchase save(List<Lotto> lottos);
    Optional<LottoPurchase> findById(Long id);
    Long setGameResult(GameResult gameResult);
}
