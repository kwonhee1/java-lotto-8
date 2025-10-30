package lotto.domain;

import java.util.List;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningLotto (List<Integer> numbers, Integer bonusNumber) {
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int winningCount(Lotto otherLotto) {

    }

    public boolean isBonus(Lotto otherLotto) {

    }

    private static class Validator {

    }

}
