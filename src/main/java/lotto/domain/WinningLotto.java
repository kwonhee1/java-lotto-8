package lotto.domain;

import java.util.List;
import lotto.domain.exception.DuplicateLottoNumberException;
import lotto.domain.exception.IllegalLottoCountException;
import lotto.domain.exception.IllegalLottoNumberException;
import lotto.validator.LottoNumberValidator;

public class WinningLotto {

    private Lotto winningLotto;
    private Integer bonusNumber;

    public WinningLotto (List<Integer> numbers, Integer bonusNumber) {
        this.winningLotto = new Lotto(numbers);
        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int winningCount(Lotto otherLotto) {
        int winningCount = 0;

        for (Integer otherLottoNumber : otherLotto.getLottoNumbers())
            if (winningLotto.contains(otherLottoNumber))
                winningCount++;

        return winningCount;
    }

    public boolean isBonus(Lotto otherLotto) {
        return otherLotto.getLottoNumbers().contains(bonusNumber);
    }

    private void validateBonusNumber(Lotto winningLotto, Integer bonusNumber) {
        LottoNumberValidator.validateLottoNumber(bonusNumber);
        if(winningLotto.contains(bonusNumber))
            throw new DuplicateLottoNumberException();
    }

}
