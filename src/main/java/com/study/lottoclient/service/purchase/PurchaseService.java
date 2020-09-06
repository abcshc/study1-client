package com.study.lottoclient.service.purchase;

import java.util.List;

public interface PurchaseService {
    void purchase(int amount, List<Lotto> collect);
}
