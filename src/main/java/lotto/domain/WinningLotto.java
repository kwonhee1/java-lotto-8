package lotto.domain;

import java.util.List;
import lotto.domain.exception.DuplicateLottoNumberException;
import lotto.domain.exception.IllegalLottoCountException;
import lotto.validator.LottoNumberValidator;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningLotto (List<Integer> numbers, Integer bonusNumber) {
        Validator.validateNumbers(numbers, bonusNumber);
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int winningCount(Lotto otherLotto) {
        int winningCount = 0;

        for (Integer otherLottoNumber : otherLotto.getLottoNumbers())
            if (winningNumbers.contains(otherLottoNumber))
                winningCount++;

        return winningCount;
    }

    public boolean isBonus(Lotto otherLotto) {
        return otherLotto.getLottoNumbers().contains(bonusNumber);
    }

    private static class Validator {
        public static void validateNumbers(List<Integer> numbers, Integer bonusNumber) {
            validateNumberLength(numbers);
            for(Integer number : numbers)
                LottoNumberValidator.validateLottoNumber(number);
            LottoNumberValidator.validateLottoNumber(bonusNumber);
            validateDuplicateNumber(numbers, bonusNumber);
        }

        private static void validateNumberLength(List<Integer> numbers) {
            if (numbers.size() != 6)
                throw new IllegalLottoCountException();
        }

        private static void validateDuplicateNumber(List<Integer> numbers, Integer bonusNumber) {
            for(int i = 0; i < numbers.size(); i++) {
                if(isContainDuplicateNumber(numbers.get(i), numbers, i+1, numbers.size()))
                    throw new DuplicateLottoNumberException();
            }

            if(isContainDuplicateNumber(bonusNumber, numbers, 0, numbers.size()))
                throw new DuplicateLottoNumberException();
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
