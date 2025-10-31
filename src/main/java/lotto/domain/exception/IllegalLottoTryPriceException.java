package lotto.domain.exception;

public class IllegalLottoTryPriceException extends IllegalArgumentException{
    private final int price;

    public IllegalLottoTryPriceException(int price) {
        this.price = price;
    }

    public int lottoTryPrice() {
        return price;
    }
}
