package com.study.lottoclient.service.purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> numbers;
    private static final Random random = new Random();

    public static Lotto create() {
        return create(List.of());
    }

    public static Lotto create(List<Integer> input) {
        if (isInvalidNumber(input)) {
            throw new IllegalArgumentException();
        }
        Lotto lotto = new Lotto();
        // input 에서 모두 작업한 후 ImmutableCollections 로 나가기
        List<Integer> numbers = new ArrayList<>(input);
        // 숫자 뽑는 pool
        if (input.size() < 6) {
            // 로또에서 나올 수 있는 숫자 모두
            Set<Integer> remains = IntStream.range(1, 46).boxed().collect(Collectors.toSet());
            // 이미 선택된 숫자 빼기
            remains.removeAll(numbers);
            
            for (int i = 0; i < 6 - input.size(); i++) {
                int selected = selectRandomNumber(remains);
                remains.remove(selected);
                numbers.add(selected);
            }

        } else if (input.size() > 6) {
            throw new IllegalArgumentException();
        }
        lotto.numbers = List.copyOf(numbers);
        return lotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int selectRandomNumber(Set<Integer> remains) {
        // 남아있는 숫자 중 랜덤 하나
        return (int) remains.toArray()[random.nextInt(remains.size())];
    }

    private static boolean isInvalidNumber(List<Integer> input) {
        for (Integer number : input) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }
}
