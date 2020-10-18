package com.study.lottoclient.service.purchase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseRepositoryTest {
    private LottoPurchaseRepository lottoPurchaseRepository;

    @BeforeEach
    void setup() {
        lottoPurchaseRepository = new LottoPurchaseRepositoryImpl();
    }

    @Test
    void test_save() {
        LottoPurchase lottoPurchase = lottoPurchaseRepository.save(List.of(Lotto.create(), Lotto.create()));
        assertEquals(lottoPurchase.getTotalPrice(), 2000);
        assertEquals(lottoPurchase.getLottos().size(), 2);
        assertNotNull(lottoPurchase.getCreateTime());
        assertNotNull(lottoPurchase.getId());
    }

    @Test
    void test_save_selectedNumber() {
        LottoPurchase lottoPurchase = lottoPurchaseRepository.save(List.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6))));
        assertEquals(1000, lottoPurchase.getTotalPrice());
        assertEquals(1, lottoPurchase.getLottos().size());
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, lottoPurchase.getLottos().get(0).getNumbers().toArray(new Integer[0]));
        assertNotNull(lottoPurchase.getCreateTime());
        assertNotNull(lottoPurchase.getId());
    }

    @Test
    void test_findById() {
        LottoPurchase lottoPurchase = lottoPurchaseRepository.save(List.of(Lotto.create(), Lotto.create()));
        assertEquals(lottoPurchase, lottoPurchaseRepository.findById(lottoPurchase.getId()).get());
    }

    @Test
    void test_findById_whenNoData() {
        assertTrue(lottoPurchaseRepository.findById(0L).isEmpty());
    }
}