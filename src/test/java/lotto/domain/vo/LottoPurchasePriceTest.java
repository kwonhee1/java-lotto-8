package lotto.domain.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchasePriceTest {

    @Test
    @DisplayName("Lotto 구매 가격은 1000으로 나누어 떨어져야 합니다")
    public void generateLottoTryPriceTest() {
        Assertions.assertThatThrownBy(()->new LottoPurchasePrice(null))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->new LottoPurchasePrice(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto purchase price는 Lotto count를 반환합니다")
    public void toLottoTryCountTest() {
        LottoPurchaseCount lottoCount = new LottoPurchasePrice(2000).toLottoTryCount();

        Assertions.assertThat(lottoCount.value()).isEqualTo(2);
    }

}
