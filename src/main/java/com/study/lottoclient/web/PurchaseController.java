package com.study.lottoclient.web;

import com.study.lottoclient.service.purchase.Lotto;
import com.study.lottoclient.service.purchase.PurchaseService;
import com.study.lottoclient.web.request.PurchaseRequest;
import com.study.lottoclient.web.response.PurchaseResponse;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController("/lotto")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    @ResponseBody
    public PurchaseResponse purchase(@RequestBody PurchaseRequest request) {
        purchaseService.purchase(request.getAmount(),
                request.getLottos()
                        .stream()
                        .map(it -> new Lotto(it.getNumbers()))
                        .collect(Collectors.toList()));
        return null;
    }
}
