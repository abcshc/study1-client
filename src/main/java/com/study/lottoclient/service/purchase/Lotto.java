package com.study.lottoclient.service.purchase;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> remains = IntStream.range(1, 46).boxed().collect(Collectors.toList());

        if (this.isInvalidNumber(numbers)) {
            throw new RuntimeException();
        }
        // TODO: 번호 자동생성 6개
        if (numbers.size() < 6) {
            for (Integer number : numbers) {
                remains.removeIf(it -> it.equals(number));
            }

            // 지우는거 완료

            for (int i = 0; i < 6 - numbers.size(); i++) {
                Random random = new Random();
                int value = random.nextInt(45) % remains.size();
                int next = remains.get(value);
                remains.remove(value);
                numbers.add(next);
            }

        } else if (numbers.size() > 6) {
            throw new RuntimeException();
        }
    }

    private boolean isInvalidNumber(List<Integer> input) {
        for (Integer number : input) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }
}
