package com.study.lottoclient.service.purchase;

import java.util.List;

public class LottoPurchase {
    private final int PRICE = 1000;
    private List<Lotto> lottos;

    public int getTotalPrice() {
        return lottos.size() * 1000;
    }
}
