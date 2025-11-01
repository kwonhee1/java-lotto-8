package lotto.domain.vo;

import lotto.domain.exception.IllegalLottoTryPriceException;

public class LottoPurchasePrice {

    int price;

    public LottoPurchasePrice(Integer price) {
        validateLottoTryPrice(price);
        this.price = price;
    }

    public LottoPurchaseCount toLottoTryCount() {
        return new LottoPurchaseCount(this.price / 1000);
    }

    public int value() {
        return price;
    }

    private void validateLottoTryPrice (Integer price) {
        if(price== null)
            throw new IllegalLottoTryPriceException(0);

        if(price % 1000 != 0)
            throw new IllegalLottoTryPriceException(price);
    }
}
