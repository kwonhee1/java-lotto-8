package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.vo.LottoPurchasePrice;
import lotto.domain.vo.LottoPurchaseCount;
import lotto.dto.TotalLottoResultDto;
import lotto.service.LotteryDrawService;
import lotto.service.LottoGenerateService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.mapper.OutputMapper;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private LottoGenerateService lottoGenerateService = new  LottoGenerateService();
    private LotteryDrawService lotteryDrawService = new  LotteryDrawService();

    public void run() {
        LottoPurchasePrice purchasePrice = inputLottoTryCount();
        List<Lotto> purchasedLottos = generateLottos(purchasePrice.toLottoTryCount());
        WinningLotto winningLotto = inputWinningLotto();
        TotalLottoResultDto result = lotteryDraw(winningLotto, purchasedLottos);
        printLottoResult(result, purchasePrice);
    }

    private LottoPurchasePrice inputLottoTryCount() {
        Integer inputPurchasePrice = inputView.inputPurchaseLottoPrice();
        LottoPurchasePrice purchasePrice = new LottoPurchasePrice(inputPurchasePrice);

        outputView.print(OutputMapper.lottoPurchaseCountToString(purchasePrice.toLottoTryCount()));

        return purchasePrice;
    }

    private List<Lotto> generateLottos(LottoPurchaseCount lottoPurchaseCount) {
        List<Lotto> generatedLottoList = lottoGenerateService.generateLottos(lottoPurchaseCount);

        outputView.print(OutputMapper.lottoListToString(generatedLottoList));

        return generatedLottoList;
    }

    private WinningLotto inputWinningLotto() {
        List<Integer> inputWinningLottoNumbers = inputView.inputWinningLottoNumbers();
        Integer bonusNumber = inputView.inputBonusNumber();
        return new WinningLotto(inputWinningLottoNumbers, bonusNumber);
    }

    private TotalLottoResultDto lotteryDraw(WinningLotto winningLotto, List<Lotto> lottos) {
        return lotteryDrawService.lotteryDraw(winningLotto, lottos);
    }

    private void printLottoResult(TotalLottoResultDto result, LottoPurchasePrice purchasePrice) {
        outputView.print(OutputMapper.totalLottoResultToString(result));
        outputView.print(OutputMapper.getWinningRate(purchasePrice, result.getTotalWinningPrice()));
    }

}
