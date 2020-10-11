package com.study.lottoclient.service.purchase;

import java.util.List;

public interface LottoPurchaseRepository {
    LottoPurchase save(List<Lotto> lottos);
}
