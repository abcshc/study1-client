package com.study.lottoclient.web;

import com.study.lottoclient.service.purchase.PurchaseService;
import com.study.lottoclient.service.result.GameResultService;
import com.study.lottoclient.web.exception.HttpNotFoundException;
import com.study.lottoclient.web.request.PurchaseRequest;
import com.study.lottoclient.web.request.SetGameResultRequest;
import com.study.lottoclient.web.response.GameResultResponse;
import com.study.lottoclient.web.response.PurchaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lotto")
public class LottoController {
    private final PurchaseService purchaseService;
    private final GameResultService gameResultService;

    public LottoController(PurchaseService purchaseService, GameResultService gameResultService) {
        this.purchaseService = purchaseService;
        this.gameResultService = gameResultService;
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
        return gameResultService.setGameResult(request.getRound(), request.convertGameResult());
    }

    @GetMapping("/result/{round}")
    @ResponseBody
    public GameResultResponse getGameResultByRound(@PathVariable Long round) {
        return new GameResultResponse(round, gameResultService.findByRound(round).orElseThrow(HttpNotFoundException::new));
    }
}
