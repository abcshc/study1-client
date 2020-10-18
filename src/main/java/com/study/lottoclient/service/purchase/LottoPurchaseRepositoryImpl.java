package com.study.lottoclient.service.purchase;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class LottoPurchaseRepositoryImpl implements LottoPurchaseRepository {
    private Map<Long, LottoPurchase> lottoPurchases = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public LottoPurchase save(List<Lotto> lottos) {
        LottoPurchase lottoPurchase = new LottoPurchase(sequence, lottos);
        lottoPurchases.put(sequence, lottoPurchase);
        sequence = sequence + 1L;
        return lottoPurchase;
    }

    @Override
    public Optional<LottoPurchase> findById(Long id) {
        return Optional.ofNullable(lottoPurchases.get(id));
    }
}
