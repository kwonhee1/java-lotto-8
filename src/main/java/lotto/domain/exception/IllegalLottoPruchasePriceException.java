package lotto.domain.exception;

public class IllegalLottoPruchasePriceException extends IllegalArgumentException{
    private final int price;

    public IllegalLottoPruchasePriceException(int price) {
        this.price = price;
    }

    public int lottoTryPrice() {
        return price;
    }
}
