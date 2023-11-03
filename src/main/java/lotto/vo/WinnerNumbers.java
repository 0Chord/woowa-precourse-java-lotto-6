package lotto.vo;

import java.util.List;
import lotto.exception.OutOfRangeNumbersException;
import lotto.exception.WrongSameNumberException;

public class WinnerNumbers extends Lotto {

    private final Integer bonusNumber;

    public WinnerNumbers(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        checkSameNumbers(numbers, bonusNumber);
        checkBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkSameNumbers(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new WrongSameNumberException();
        }
    }

    private void checkBonusNumberInRange(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new OutOfRangeNumbersException();
        }
    }

}