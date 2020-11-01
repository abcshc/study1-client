package com.study.lottoclient.service.purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    LottoPurchase purchase(List<Lotto> lottos);

    Optional<LottoPurchase> findById(Long id);
}
