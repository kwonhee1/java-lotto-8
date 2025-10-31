package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.dto.TotalLottoResultDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryDrawServiceTest {

    private LotteryDrawService lotteryDrawService = new  LotteryDrawService();

    @Test
    @DisplayName("lottery draw service는 LottoResult를 생성합니다")
    public void lotteryDrawTest() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        List<Lotto> lottos = List.of(lotto);

        TotalLottoResultDto result = lotteryDrawService.lotteryDraw(winningLotto, lottos);
        TotalLottoResultDto expected = new TotalLottoResultDto();
        expected.addResult(new LottoResult(5,true).toDto());

        org.junit.jupiter.api.Assertions.assertAll(
                ()->Assertions.assertThat(result.getTotalLottoCount())
                        .isEqualTo(expected.getTotalLottoCount()),
                ()->Assertions.assertThat(result.getTotalWinningPrice())
                        .isEqualTo(expected.getTotalWinningPrice()),
                ()->Assertions.assertThat(result.getWinningCount(LottoRank.SECOND))
                        .isEqualTo(expected.getWinningCount(LottoRank.SECOND)),
                ()->Assertions.assertThat(result.getWinningPrice(LottoRank.SECOND))
                        .isEqualTo(expected.getWinningPrice(LottoRank.SECOND))
        );

    }
}
