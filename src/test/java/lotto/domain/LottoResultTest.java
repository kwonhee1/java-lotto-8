package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    @DisplayName("LottoResult는 winningCount와 isBonus로 Lotto 결과를 반환한다")
    public void lottoResultTest() {
        LottoResult lottoResult = new LottoResult(5, true);
        LottoRank lottoRank = lottoResult.lottoRank();

        Assertions.assertThat(lottoRank.getPrice()).isEqualTo(LottoRank.SECOND.getPrice());
    }

}
