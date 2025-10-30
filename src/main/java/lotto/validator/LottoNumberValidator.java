package lotto.validator;

import lotto.domain.exception.IllegalLottoNumberException;

public class LottoNumberValidator {
    public static void validateLottoNumber(Integer number) {
        if(1 > number.intValue() || number.intValue() > 45)
            throw new IllegalLottoNumberException(number);
    }
}
