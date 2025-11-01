package lotto.domain;

import java.util.List;
import lotto.constraint.LottoConstraint;
import lotto.domain.exception.DuplicateLottoNumberException;
import lotto.domain.exception.IllegalLottoCountException;
import lotto.validator.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public boolean contains(Integer otherNumber) {
        return numbers.contains(otherNumber);
    }

    static private class Validator {
        public static void validateLotto(List<Integer> numbers) {
            validateLottoCount(numbers);
            for(Integer number : numbers)
                LottoNumberValidator.validateLottoNumber(number);
            validateDuplicateNumber(numbers);
        }

        private static void validateLottoCount(List<Integer> numbers) {
            if (numbers.size() != LottoConstraint.LOTTO_COUNT)
                throw new IllegalLottoCountException();
        }

        private static void validateDuplicateNumber(List<Integer> numbers) {
            for(int i = 0; i < numbers.size(); i++) {
                if(isContainDuplicateNumber(numbers.get(i), numbers, i+1, numbers.size()))
                    throw new DuplicateLottoNumberException();
            }
        }

        private static boolean isContainDuplicateNumber(Integer targetNumber, List<Integer> numbers, int start, int end) {
            for(int otherLottoIter = start; otherLottoIter < end; otherLottoIter++) {
                if (targetNumber.equals(numbers.get(otherLottoIter)))
                    return true;
            }
            return false;
        }
    }
}