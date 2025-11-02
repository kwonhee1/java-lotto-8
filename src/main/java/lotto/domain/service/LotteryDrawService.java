package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

public class LotteryDrawService {

    public List<LottoResult> lotteryDraw(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoResult> lottoResultList = new ArrayList<>();

        for(Lotto eachLotto : lottos) {
            LottoResult eachResult = lotteryDraw(winningLotto, eachLotto);
            lottoResultList.add(eachResult);
        }

        return lottoResultList;
    }

    private LottoResult lotteryDraw(WinningLotto winningLotto, Lotto lotto) {
        int winningCount = winningLotto.winningCount(lotto);
        boolean isBonus = winningLotto.isBonus(lotto);

        return new LottoResult(winningCount, isBonus);
    }

}
