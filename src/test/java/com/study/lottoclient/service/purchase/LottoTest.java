package com.study.lottoclient.service.purchase;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    // 6개 이상 입력 시, 숫자의 범위가 넘어설 경우 예외 발생
    @Test
    void test_createLotto_returnNumbers_whenNoInput() {
        Lotto case1 = Lotto.create();
        // 중복되지 않은 숫자가 6개 생성됬는지 확인
        // assertEquals(expected, actual)
        assertEquals(6, case1.getNumbers().size());
        // 1을 포함한 중복되지 않은 숫자 5개 총 개수는 6개
    }

    @Test
    void test_createLotto_returnNumbers_whenOneInput() {
        Lotto case2 = Lotto.create(List.of(1));
        // assertThat (actual, matcher)
        // 입력받는게 matcher에 맞는지 확인
        assertEquals(6, case2.getNumbers().size());
        assertTrue(case2.getNumbers().contains(1));
    }

    @Test
    void test_createLotto_returnNumbers_whenTwoInput() {
        Lotto case2 = Lotto.create(List.of(1, 2));
        // assertThat (actual, matcher)
        // 입력받는게 matcher에 맞는지 확인
        assertEquals(6, case2.getNumbers().size());
        assertTrue(case2.getNumbers().contains(1));
        assertTrue(case2.getNumbers().contains(2));
    }

    @Test
    void test_createLotto_returnNumbers_whenAllInput() {
        // 입력한 숫자 6개가 있는지 확인
        Lotto case3 = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(6, case3.getNumbers().size());
        assertThat(case3.getNumbers(), contains(1, 2, 3, 4, 5, 6));
    }

    @Test
    void test_createLotto_throwIllegalArgumentException_when6자리넘을경우() {
        //assertThrows (Class<T> expectedType, Executable executable)
        assertThrows(IllegalArgumentException.class, () -> {
            Lotto.create(List.of(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @Test
    void test_createLotto_throwIllegalArgumentException_when1미만() {
        assertThrows(IllegalArgumentException.class, () -> {
            Lotto.create(List.of(0));
        });
    }

    @Test
    void test_createLotto_throwIllegalArgumentException_when45초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            Lotto.create(List.of(46));
        });
    }

    @Test
    void test_selectRandomNumber() {
        Set<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toSet());
        for (int i = 0; i < 200; i++) {
            int selected = Lotto.selectRandomNumber(lottoNumbers);
            assertTrue(selected >= 1 && selected <= 45);
        }

        Set<Integer> lottoNumbers2 = IntStream.range(1, 46).boxed().collect(Collectors.toSet());
        lottoNumbers2.removeAll(List.of(1, 2, 3, 4));
        for (int i = 0; i < 200; i++) {
            int selected = Lotto.selectRandomNumber(lottoNumbers2);
            assertTrue(selected >= 5 && selected <= 45);
        }

        Set<Integer> lottoNumbers3 = Set.of(44, 45);
        for (int i = 0; i < 200; i++) {
            int selected = Lotto.selectRandomNumber(lottoNumbers3);
            assertTrue(selected >= 44 && selected <= 45);
        }
    }
}