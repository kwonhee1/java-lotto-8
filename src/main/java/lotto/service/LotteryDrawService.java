package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.dto.TotalLottoResultDto;

public class LotteryDrawService {

    public TotalLottoResultDto lotteryDraw(WinningLotto winningLotto, List<Lotto> lottos) {
        TotalLottoResultDto totalResult = new TotalLottoResultDto();

        for(Lotto eachLotto : lottos) {
            LottoResult eachResult = lotteryDraw(winningLotto, eachLotto);
            totalResult.addResult(eachResult.lottoRank());
        }

        return totalResult;
    }

    private LottoResult lotteryDraw(WinningLotto winningLotto, Lotto lotto) {
        int winningCount = winningLotto.winningCount(lotto);
        boolean isBonus = winningLotto.isBonus(lotto);

        return new LottoResult(winningCount, isBonus);
    }

}
