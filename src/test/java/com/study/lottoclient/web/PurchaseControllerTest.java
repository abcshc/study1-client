package com.study.lottoclient.web;

import com.study.lottoclient.service.purchase.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PurchaseControllerTest {
    private PurchaseService purchaseService = mock(PurchaseService.class);
    private PurchaseController purchaseController = new PurchaseController(purchaseService);
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(purchaseController).build();

    @Test
    void test_getLottoById_responseNotFound() throws Exception {
        when(purchaseService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/lotto")
                .param("id", "1"))
                .andExpect(status().isNotFound());
    }
}