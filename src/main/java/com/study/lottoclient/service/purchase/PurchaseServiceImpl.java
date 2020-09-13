package com.study.lottoclient.service.purchase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Override
    public void purchase(int amount, List<Lotto> lottos) {
        // lotto는 개당 1000원
        if(amount != lottos.size() * 1000) {
            // TODO: 잘못된 금액인 경우 예외처리
            throw new RuntimeException();
        }

        // amount - 구매 금액
        //TODO : amount 랑 로또의 사이즈랑 비교해서 잘못된 요청인지 확인 (/)
        //       잘못된 로또 번호 확인 (중복된 번호나, 45 넘는 숫자가 있는지 아니면 1보다 작은 숫자가 있는지) (/)
        //       자동 생성 필요 확인과 자동 생성
        //       로또 구매 내역 기록
    }
}

