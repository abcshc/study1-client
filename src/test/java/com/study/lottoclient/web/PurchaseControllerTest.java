package com.study.lottoclient.web;

import com.study.lottoclient.service.purchase.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PurchaseController.class)
class PurchaseControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PurchaseService purchaseService = mock(PurchaseService.class);

    @Test
    void test_getLottoById_responseNotFound() throws Exception {
        when(purchaseService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/lotto")
                .param("id", "1"))
                .andExpect(status().isNotFound());
    }
}