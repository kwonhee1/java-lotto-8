package lotto.domain.vo;

import lotto.constraint.LottoConstraint;
import lotto.domain.exception.IllegalLottoPruchasePriceException;

public class LottoPurchasePrice {

    int price;

    public LottoPurchasePrice(Integer price) {
        validateLottoTryPrice(price);
        this.price = price;
    }

    public int price() {
        return price;
    }

    public int toCount() {
        return price / LottoConstraint.LOTTO_PRICE;
    }

    private void validateLottoTryPrice (Integer price) {
        if(price== null)
            throw new IllegalLottoPruchasePriceException(0);

        if(price <= 0)
            throw new IllegalLottoPruchasePriceException(price);

        if(price % LottoConstraint.LOTTO_PRICE != 0)
            throw new IllegalLottoPruchasePriceException(price);
    }
}
