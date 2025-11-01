package lotto.validator;

import lotto.constraint.LottoConstraint;
import lotto.domain.exception.IllegalLottoNumberException;

public class LottoNumberValidator {
    public static void validateLottoNumber(Integer number) {
        if(LottoConstraint.LOTTO_RANGE_START_INCLUSIVE > number.intValue() || number.intValue() >LottoConstraint.LOTTO_RANGE_END_INCLUSIVE)
            throw new IllegalLottoNumberException(number);
    }
}
