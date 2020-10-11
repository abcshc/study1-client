package com.study.lottoclient.web;

import com.study.lottoclient.service.purchase.Lotto;
import com.study.lottoclient.service.purchase.PurchaseService;
import com.study.lottoclient.web.request.PurchaseRequest;
import com.study.lottoclient.web.response.PurchaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController("/lotto")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    @ResponseBody
    public PurchaseResponse purchase(@RequestBody PurchaseRequest request) {
//        purchaseService.purchase(request.getAmount(),
//                request.getLottos()
//                        .stream()
//                        .map(it -> Lotto.create(it.getNumbers()))
//                        .collect(Collectors.toList()));
        return null;
    }
}
