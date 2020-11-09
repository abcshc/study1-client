package com.study.lottoclient.web;

import com.study.lottoclient.service.purchase.Lotto;
import com.study.lottoclient.service.purchase.LottoPurchase;
import com.study.lottoclient.service.purchase.PurchaseService;
import com.study.lottoclient.service.result.GameResult;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PurchaseControllerTest {
    private PurchaseService purchaseService = mock(PurchaseService.class);
    private PurchaseController purchaseController = new PurchaseController(purchaseService);
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(purchaseController).build();

    @Test
    void test_getLottoById_responseNotFound() throws Exception {
        when(purchaseService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/lotto")
                .param("id", "1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void test_getLottoById_success() throws Exception {
        when(purchaseService.findById(1L))
                .thenReturn(Optional.of(new LottoPurchase(1L, List.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6))))));

        mockMvc.perform(get("/lotto")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.createTime").exists())
                .andExpect(jsonPath("$.lottos[0].numbers[0]").value(1))
                .andExpect(jsonPath("$.lottos[0].numbers[1]").value(2))
                .andExpect(jsonPath("$.lottos[0].numbers[2]").value(3))
                .andExpect(jsonPath("$.lottos[0].numbers[3]").value(4))
                .andExpect(jsonPath("$.lottos[0].numbers[4]").value(5))
                .andExpect(jsonPath("$.lottos[0].numbers[5]").value(6));
    }

    @Test
    void test_purchase_success() throws Exception {
        when(purchaseService.purchase(List.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)))))
                .thenReturn(new LottoPurchase(1L, List.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)))));

        mockMvc.perform(post("/lotto")
                .contentType(MediaType.APPLICATION_JSON)
                //language=json
                .content("{\n" +
                        "  \"lottos\": [\n" +
                        "    {\"numbers\":[1, 2, 3, 4, 5, 6]}\n" +
                        "  ]\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.createTime").exists())
                .andExpect(jsonPath("$.lottos[0].numbers[0]").value(1))
                .andExpect(jsonPath("$.lottos[0].numbers[1]").value(2))
                .andExpect(jsonPath("$.lottos[0].numbers[2]").value(3))
                .andExpect(jsonPath("$.lottos[0].numbers[3]").value(4))
                .andExpect(jsonPath("$.lottos[0].numbers[4]").value(5))
                .andExpect(jsonPath("$.lottos[0].numbers[5]").value(6));
    }

    @Test
    void test_setGameResult_success() throws Exception {
        when(purchaseService.setGameResult(
                new GameResult(List.of(1, 2, 3, 4, 5, 6), 7, LocalDate.of(2020, 11, 8)))
        ).thenReturn(1L);

        mockMvc.perform(post("/lotto/result")
                .contentType(MediaType.APPLICATION_JSON)
                //language=json
                .content("{\n" +
                        "  \"winningNumbers\": [1, 2, 3, 4, 5, 6],\n" +
                        "  \"bonusNumber\" : 7,\n" +
                        "  \"createDate\" : \"2020-11-08\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}