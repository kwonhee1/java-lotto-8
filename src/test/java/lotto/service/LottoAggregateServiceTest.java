package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.dto.LottoAggregateDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoAggregateServiceTest {

    @Test
    @DisplayName("LottoResult를 aggregate한 결과를 반환한다")
    public void lottoAggregateServiceTest(){
        List<LottoResult> drawResult = List.of(new LottoResult(3,false));
        LottoAggregateDto dto = new LottoAggregateService().aggregate(drawResult);

        int totalWinningPrice = dto.getTotalWinningPrice();
        int winningCountFifth = dto.getWinningCount(LottoRank.FIFTH);
        int winningCountFirst = dto.getWinningCount(LottoRank.FIRST);

        org.junit.jupiter.api.Assertions.assertAll(
                ()->Assertions.assertThat(totalWinningPrice).isEqualTo(LottoRank.FIFTH.getPrice()),
                ()->Assertions.assertThat(winningCountFifth).isEqualTo(1),
                ()->Assertions.assertThat(winningCountFirst).isEqualTo(0)
        );
    }
}
