package lotto.domain.vo;

import lotto.domain.exception.IllegalLottoPurchaseCountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseCountTest {

    @Test
    @DisplayName("Lotto count 는 1이상이어야 합니다")
    public void lottoTryCountTest() {
        Assertions.assertThatThrownBy(() -> new LottoPurchaseCount(0))
                .isInstanceOf(IllegalLottoPurchaseCountException.class);
        Assertions.assertThatThrownBy(() -> new LottoPurchaseCount(null))
                .isInstanceOf(IllegalLottoPurchaseCountException.class);
    }

}
