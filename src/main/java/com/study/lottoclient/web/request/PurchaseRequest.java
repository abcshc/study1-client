package com.study.lottoclient.web.request;

import com.study.lottoclient.service.purchase.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseRequest {
    private List<LottoRequest> lottos;

    public List<LottoRequest> getLottos() {
        return lottos;
    }

    public static class LottoRequest {
        private List<Integer> numbers;

        public List<Integer> getNumbers() {
            return numbers;
        }
    }

    public List<Lotto> convertToLotto() {
        return lottos.stream()
                .map(it -> Lotto.create(it.getNumbers()))
                .collect(Collectors.toList());
    }
}
