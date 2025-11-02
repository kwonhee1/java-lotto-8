package lotto.controller.exception;

import lotto.domain.exception.DuplicateLottoNumberException;
import lotto.domain.exception.IllegalLottoCountException;
import lotto.domain.exception.IllegalLottoNumberException;
import lotto.domain.exception.IllegalLottoTryCountException;
import lotto.domain.exception.IllegalLottoTryPriceException;
import lotto.view.ErrorMessage;

public class ExceptionHandler {

    @TargetException(DuplicateLottoNumberException.class)
    public <T extends IllegalArgumentException> String duplicateLottoNumber(T exception) {
        return ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage();
    }

    @TargetException(IllegalLottoNumberException.class)
    public <T extends IllegalArgumentException> String illegalLottoNumber(T exception) {
        IllegalLottoNumberException e = (IllegalLottoNumberException) exception;

        return ErrorMessage.ILLEGAL_LOTTO_NUMBER.getMessage(String.valueOf(e.getIllegalLottoNumber()));
    }

    @TargetException(IllegalLottoCountException.class)
    public <T extends IllegalArgumentException> String illegalLottoCount(T exception) {
        return ErrorMessage.ILLEGAL_LOTTO_LENGTH.getMessage();
    }

    @TargetException({IllegalLottoTryCountException.class, IllegalLottoTryPriceException.class})
    public <T extends IllegalArgumentException> String IllegalPurchaseLotto(T exception) {
        return ErrorMessage.ILLEGAL_PURCHASE_LOTTO_PRICE.getMessage();
    }

    @TargetException(NumberFormatException.class)
    public <T extends IllegalArgumentException> String handelNumberFormatException(T exception) {
        return ErrorMessage.NUMBER_FORMAT.getMessage();
    }

}
