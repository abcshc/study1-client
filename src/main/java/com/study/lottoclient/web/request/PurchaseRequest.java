package com.study.lottoclient.web.request;

import lombok.Getter;

import java.util.List;

@Getter
public class PurchaseRequest {
    private int amount;

    private List<LottoRequest> lottos;

    @Getter
    public class LottoRequest {
        List<Integer> numbers;
    }
}
