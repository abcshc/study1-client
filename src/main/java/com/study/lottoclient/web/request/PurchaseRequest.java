package com.study.lottoclient.web.request;

import lombok.Getter;

import java.util.List;

public class PurchaseRequest {
    private int amount;
    private List<LottoRequest> lottos;

    public int getAmount() {
        return amount;
    }
    
    public List<LottoRequest> getLottos() {
        return lottos;
    }

    @Getter
    public class LottoRequest {
        private List<Integer> numbers;

        public List<Integer> getNumbers() {
            return numbers;
        }
    }
}
