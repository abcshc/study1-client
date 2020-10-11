package com.study.lottoclient.service.purchase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final LottoPurchaseRepository lottoPurchaseRepository;

    public PurchaseServiceImpl(LottoPurchaseRepository lottoPurchaseRepository) {
        this.lottoPurchaseRepository = lottoPurchaseRepository;
    }
    // repository (db와 연결) mock 테스트
    // 거스름돈 같은건 필요 없도록 하기, amount 빼고, 장당 가격을 final로 두고 계산할 수 있도록 하기
    // 상금을 어디에 작성해놓을까
    // 어플리케이션 띄워져 있는 동안 메모리에 저장 (DB X)

    @Override
    public LottoPurchase purchase(List<Lotto> lottos) {
        // TODO: 저장, 로또 구매 내역 기록
        return lottoPurchaseRepository.purchase(lottos);
    }
}

