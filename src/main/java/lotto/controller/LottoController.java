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

    private LottoGenerateService generateService = new  LottoGenerateService();
    private LotteryDrawService lotteryDrawService = new  LotteryDrawService();

    public void run() {
        LottoPurchaseCount purchaseCount = inputLottoTryCount();
        List<Lotto> purchasedLottos = generateLottos(purchaseCount);
        WinningLotto winningLotto = inputWinningLotto();
        TotalLottoResultDto lottoDrawResult = lotteryDraw(winningLotto, purchasedLottos);
        printLottoResult(lottoDrawResult, purchaseCount);
    }

    private LottoPurchaseCount inputLottoTryCount() {
        Integer inputPurchasePrice = inputView.inputPurchaseLottoPrice();
        LottoPurchasePrice purchasePrice = new LottoPurchasePrice(inputPurchasePrice);
        LottoPurchaseCount purchaseCount = purchasePrice.toLottoTryCount();

        outputView.print(OutputMapper.lottoPurchaseCountToString(purchaseCount));

        return purchaseCount;
    }

    private List<Lotto> generateLottos(LottoPurchaseCount lottoPurchaseCount) {
        List<Lotto> generatedLottoList = generateService.generateLottos(lottoPurchaseCount);

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

    private void printLottoResult(TotalLottoResultDto result, LottoPurchaseCount purchaseCount) {
        outputView.print(OutputMapper.totalLottoResultToString(result));
        int purchasePrice = LottoPurchasePrice.getPriceFromPurchaseCount(purchaseCount);
        outputView.print(OutputMapper.getWinningRate(purchasePrice, result.getTotalWinningPrice()));
    }

}
