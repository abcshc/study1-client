package com.study.lottoclient.web;

import com.study.lottoclient.service.purchase.PurchaseService;
import com.study.lottoclient.web.request.PurchaseRequest;
import com.study.lottoclient.web.response.PurchaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lotto")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }



    @PostMapping
    @ResponseBody
    public PurchaseResponse purchase(@RequestBody PurchaseRequest request) {
        return new PurchaseResponse(purchaseService.purchase(request.convertToLotto()));
    }
}
