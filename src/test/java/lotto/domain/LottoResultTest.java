package lotto.domain;

import lotto.dto.LottoResultDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    @DisplayName("LottoResult는 winningCount와 isBonus로 Lotto 결과를 반환한다")
    public void lottoResultTest() {
        LottoResult lottoResult = new LottoResult(5, true);
        LottoResultDto lottoResultDto = lottoResult.toDto();

        Assertions.assertThat(lottoResultDto.getPrice()).isEqualTo(LottoRank.SECOND.getPrice());
    }

}
