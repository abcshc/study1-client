package com.study.lottoclient;

import com.study.lottoclient.service.purchase.PurchaseServiceImpl;
import com.study.lottoclient.web.PurchaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LottoClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(LottoClientApplication.class, args);
    }
}
