package com.study.lottoclient.web.response;

import com.study.lottoclient.service.purchase.LottoPurchase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseResponse {
    private Long id;

    private String createTime;

    private List<LottoResponse> lottos;

    public class LottoResponse {
        private List<Integer> numbers;

        public List<Integer> getNumbers() {
            return numbers;
        }
    }

    public Long getId() {
        return id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public List<LottoResponse> getLottos() {
        return lottos;
    }

    public PurchaseResponse() {
    }

    public PurchaseResponse(LottoPurchase lottoPurchase) {
        this.id = lottoPurchase.getId();
        this.createTime = lottoPurchase.getCreateTime().toString();
        this.lottos = lottoPurchase.getLottos().stream().map(it -> {
            LottoResponse lottoResponse = new LottoResponse();
            lottoResponse.numbers = it.getNumbers();
            return lottoResponse;
        }).collect(Collectors.toList());
    }
}
