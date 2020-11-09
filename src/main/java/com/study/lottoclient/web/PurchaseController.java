package com.study.lottoclient.web;

import com.study.lottoclient.service.purchase.PurchaseService;
import com.study.lottoclient.web.exception.HttpNotFoundException;
import com.study.lottoclient.web.request.PurchaseRequest;
import com.study.lottoclient.web.request.SetGameResultRequest;
import com.study.lottoclient.web.response.PurchaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lotto")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    @ResponseBody
    public PurchaseResponse getLottoById(@RequestParam Long id) {
        return new PurchaseResponse(purchaseService.findById(id).orElseThrow(HttpNotFoundException::new));
    }

    @PostMapping
    @ResponseBody
    public PurchaseResponse purchase(@RequestBody PurchaseRequest request) {
        return new PurchaseResponse(purchaseService.purchase(request.convertToLotto()));
    }

    @PostMapping("/result")
    @ResponseBody
    public Long setGameResult(@RequestBody SetGameResultRequest request) {
        return purchaseService.setGameResult(request.convertGameResult());
    }
}
