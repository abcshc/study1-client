package com.study.lottoclient.service.purchase;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LottoPurchaseRepositoryImpl implements LottoPurchaseRepository {
    // 구매정보 저장, index정보를 포함시키거나
    // TODO: 구매 ID 생성 후 구매, 저장, 조회 Create, Read
    private Map<Long, LottoPurchase> lottoPurchases = new HashMap<>();

    @Override
    public LottoPurchase save(List<Lotto> lottos) {
        return null;
    }
}
