package lotto.domain.vo;

import lotto.domain.exception.IllegalLottoTryCountException;

public class LottoPurchaseCount {
    private int tryCount;

    public LottoPurchaseCount(Integer tryCount) {
        validateLottoTryCount(tryCount);
        this.tryCount = tryCount;
    }

    public int value() {
        return tryCount;
    }

    private void validateLottoTryCount(Integer tryCount) {
        if (tryCount == null || tryCount < 1) {
            throw new IllegalLottoTryCountException();
        }
    }

}
