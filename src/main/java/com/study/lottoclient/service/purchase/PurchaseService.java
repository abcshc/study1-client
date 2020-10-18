package com.study.lottoclient.service.purchase;

import java.util.List;

public interface PurchaseService {
    LottoPurchase purchase(List<Lotto> lottos);

    LottoPurchase findById(Long id);
}
