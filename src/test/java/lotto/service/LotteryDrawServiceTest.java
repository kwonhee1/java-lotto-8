package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.domain.service.LotteryDrawService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryDrawServiceTest {

    private LotteryDrawService lotteryDrawService = new  LotteryDrawService();

    @Test
    @DisplayName("lottery draw service는 lottery draw 결과를 반환합니다")
    public void lotteryDrawTest() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        List<Lotto> lottos = List.of(lotto);

        List<LottoResult> drawResult = lotteryDrawService.lotteryDraw(winningLotto, lottos);

        Assertions.assertThat(drawResult.get(0).lottoRank()).isEqualTo(LottoRank.SECOND);
    }
}
