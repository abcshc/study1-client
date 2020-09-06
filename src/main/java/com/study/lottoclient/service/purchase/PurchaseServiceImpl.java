package com.study.lottoclient.service.purchase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Override
    public void purchase(int amount, List<Lotto> lottos) {
        //TODO : amount 랑 로또의 사이즈랑 비교해서 잘못된 요청인지 확인
        //       잘못된 로또 번호 확인 (중복된 번호나, 45 넘는 숫자가 있는지 아니면 1보다 작은 숫자가 있는지)
        //       로또 구매 내역 기록
        //       자동 생성 필요 확인과 자동 생성
    }
}
