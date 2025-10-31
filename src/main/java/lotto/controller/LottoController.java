package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.vo.LottoPurchasePrice;
import lotto.domain.vo.LottoPurchaseCount;
import lotto.dto.TotalLottoResultDto;
import lotto.service.LotteryDrawService;
import lotto.service.LottoGenerateService;

public class LottoController {

    private LottoGenerateService lottoGenerateService = new  LottoGenerateService();
    private LotteryDrawService lotteryDrawService = new  LotteryDrawService();

    public void run() {
        LottoPurchaseCount purchaseCount = inputLottoTryCount();
        List<Lotto> purchasedLottos = generateLottos(purchaseCount);
        WinningLotto winningLotto = inputWinningLotto();
        TotalLottoResultDto result = lotteryDraw(winningLotto, purchasedLottos);
        printLottoResult(result);
    }

    private LottoPurchaseCount inputLottoTryCount() {
        return new LottoPurchasePrice(2000).toLottoTryCount();
    }

    private List<Lotto> generateLottos(LottoPurchaseCount lottoPurchaseCount) {
        return lottoGenerateService.generateLottos(lottoPurchaseCount);
    }

    private WinningLotto inputWinningLotto() {
        return new WinningLotto(List.of(1,2,3,4,5,6),7);
    }

    private TotalLottoResultDto lotteryDraw(WinningLotto winningLotto, List<Lotto> lottos) {
        return lotteryDrawService.lotteryDraw(winningLotto, lottos);
    }

    private void printLottoResult(TotalLottoResultDto result) {

    }

}
