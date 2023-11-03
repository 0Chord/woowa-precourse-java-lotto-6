package lotto.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.OutOfRangeNumbersException;
import lotto.exception.WrongSameNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSameNumbers(numbers);
        checkNumbersInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSameNumbers(List<Integer> numbers) {
        Set<Integer> comparisonTarget = new HashSet<>(numbers);
        if (comparisonTarget.size() != 6) {
            throw new WrongSameNumberException();
        }
    }

    private void checkNumbersInRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number <= 0 || number > 45)
                .findAny()
                .ifPresent(number -> {
                    throw new OutOfRangeNumbersException();
                });

    }
}