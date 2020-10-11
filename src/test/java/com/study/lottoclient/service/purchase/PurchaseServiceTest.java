package com.study.lottoclient.service.purchase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PurchaseServiceTest {
    @Autowired
    private PurchaseService purchaseService;

    @Test
    void test_purchase(){
        assertEquals(2000, purchaseService.purchase(List.of(Lotto.create(), Lotto.create())).getTotalPrice());
    }
}