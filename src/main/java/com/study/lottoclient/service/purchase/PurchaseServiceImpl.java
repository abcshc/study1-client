package com.study.lottoclient.service.purchase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final LottoPurchaseRepository lottoPurchaseRepository;

    public PurchaseServiceImpl(LottoPurchaseRepository lottoPurchaseRepository) {
        this.lottoPurchaseRepository = lottoPurchaseRepository;
    }
    // 상금을 어디에 작성해놓을까

    @Override
    public LottoPurchase purchase(List<Lotto> lottos) {
        return lottoPurchaseRepository.save(lottos);
    }

    @Override
    public LottoPurchase findById(Long id) {
        return lottoPurchaseRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}

