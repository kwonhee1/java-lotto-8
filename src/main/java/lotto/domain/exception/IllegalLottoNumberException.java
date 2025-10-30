package lotto.domain.exception;

public class IllegalLottoNumberException extends IllegalArgumentException {
    private int illegalLottoNumber;

    public IllegalLottoNumberException(int illegalLottoNumber) {
        this.illegalLottoNumber = illegalLottoNumber;
    }

    public int getIllegalLottoNumber() {
        return illegalLottoNumber;
    }
}
