package com.study.lottoclient.service.purchase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PurchaseServiceTest {
    private PurchaseService purchaseService;
    private LottoPurchaseRepository repository = mock(LottoPurchaseRepository.class);

    @BeforeEach
    void setup() {
        purchaseService = new PurchaseServiceImpl(repository);
    }

    @Test
    void test_purchase() {
        List<Lotto> lottos = List.of(Lotto.create());
        when(repository.save(lottos)).thenReturn(new LottoPurchase(0L, lottos));
        when(repository.save(any())).thenReturn(new LottoPurchase(1L, List.of(Lotto.create())));


        assertEquals(1000, purchaseService.purchase(List.of(Lotto.create())).getTotalPrice());
        verify(repository).save(any());
        assertEquals(1000, purchaseService.purchase(lottos).getTotalPrice());
        verify(repository).save(lottos);
    }

    @Test
    void test_findById() {
        when(repository.findById(0L)).thenReturn(Optional.of(new LottoPurchase(0L, List.of(Lotto.create()))));

        assertEquals(1, purchaseService.findById(0L).getLottos().size());
    }

    @Test
    void test_findById_throwRuntimeException_whenNotFound() {
        when(repository.findById(0L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> purchaseService.findById(0L));
    }
}