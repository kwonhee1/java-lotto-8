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
        Assertions.assertThatThrownBy(()->new LottoPurchasePrice(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto purchase price는 Lotto count를 반환합니다")
    public void toLottoTryToCountTest() {
        LottoPurchasePrice lottoCount = new LottoPurchasePrice(2000);

        Assertions.assertThat(lottoCount.toCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("Lotto purchase price는 Lotto price를 반환합니다")
    public void toLottoTryPriceTest() {
        LottoPurchasePrice lottoCount = new LottoPurchasePrice(2000);

        Assertions.assertThat(lottoCount.price).isEqualTo(2000);
    }

}
