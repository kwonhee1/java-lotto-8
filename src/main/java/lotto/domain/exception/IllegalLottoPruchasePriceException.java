package lotto.domain.exception;

public class IllegalLottoPruchasePriceException extends IllegalArgumentException{
    private final int illegalPrice;

    public IllegalLottoPruchasePriceException(int illegalPrice) {
        this.illegalPrice = illegalPrice;
    }

    public int getIllegalPrice() {
        return illegalPrice;
    }
}
