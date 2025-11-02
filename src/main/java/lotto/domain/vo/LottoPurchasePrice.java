package lotto.domain.vo;

import lotto.constraint.LottoConstraint;
import lotto.domain.exception.IllegalLottoPruchasePriceException;

public class LottoPurchasePrice {

    int price;

    public LottoPurchasePrice(Integer price) {
        validateLottoTryPrice(price);
        this.price = price;
    }

    public LottoPurchaseCount toLottoTryCount() {
        return new LottoPurchaseCount(this.price / LottoConstraint.LOTTO_PRICE);
    }

    public int value() {
        return price;
    }

    public static int getPriceFromPurchaseCount(LottoPurchaseCount count) {
        return count.value() * LottoConstraint.LOTTO_PRICE;
    }

    private void validateLottoTryPrice (Integer price) {
        if(price== null)
            throw new IllegalLottoPruchasePriceException(0);

        if(price % LottoConstraint.LOTTO_PRICE != 0)
            throw new IllegalLottoPruchasePriceException(price);
    }
}
