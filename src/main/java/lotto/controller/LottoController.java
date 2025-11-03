package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.controller.exception.ExceptionHandler;
import lotto.controller.exception.ExceptionMapper;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.domain.vo.LottoPurchasePrice;
import lotto.domain.service.LotteryDrawService;
import lotto.domain.service.LottoGenerateService;
import lotto.dto.LottoAggregateDto;
import lotto.service.LottoAggregateService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.mapper.OutputMapper;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;

    private ExceptionMapper exceptionMapper = new ExceptionMapper(new ExceptionHandler());

    private LottoGenerateService generateService = new LottoGenerateService();
    private LotteryDrawService lotteryDrawService = new LotteryDrawService();
    private LottoAggregateService lottoAggregateService = new LottoAggregateService();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoPurchasePrice purchasePrice = supply(()->inputLottoTryCount());
        List<Lotto> purchasedLottos = generateLottos(purchasePrice);
        WinningLotto winningLotto = supply(()->inputWinningLotto());
        LottoAggregateDto lotteryResult = processLotteryDraw(winningLotto, purchasedLottos);
        printLottoResult(lotteryResult, purchasePrice);
    }

    private LottoPurchasePrice inputLottoTryCount() {
        Integer inputPurchasePrice = inputView.inputPurchaseLottoPrice();
        LottoPurchasePrice purchaseInfo = new LottoPurchasePrice(inputPurchasePrice);

        outputView.print(OutputMapper.lottoPurchaseCountToString(purchaseInfo));

        return purchaseInfo;
    }

    private List<Lotto> generateLottos(LottoPurchasePrice lottoPurchasePrice) {
        List<Lotto> generatedLottoList = generateService.generateLottos(lottoPurchasePrice.toCount());

        outputView.print(OutputMapper.lottoListToString(generatedLottoList));

        return generatedLottoList;
    }

    private WinningLotto inputWinningLotto() {
        List<Integer> inputWinningLottoNumbers = inputView.inputWinningLottoNumbers();
        Integer bonusNumber = inputView.inputBonusNumber();
        return new WinningLotto(inputWinningLottoNumbers, bonusNumber);
    }

    private LottoAggregateDto processLotteryDraw(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoResult> drawResultList = lotteryDrawService.lotteryDraw(winningLotto, lottos);
        LottoAggregateDto aggregateResultDto = lottoAggregateService.aggregate(drawResultList);

        return aggregateResultDto;
    }

    private void printLottoResult(LottoAggregateDto lotteryResult, LottoPurchasePrice lottoPurchasePrice) {
        outputView.print(OutputMapper.totalLottoResultToString(lotteryResult));
        outputView.print(OutputMapper.getWinningRate(lottoPurchasePrice.price(), lotteryResult.getTotalWinningPrice()));
    }

    private <T> T supply(Supplier<T> supplier) {
        while(true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.print(exceptionMapper.toMessage(e));
            }
        }
    }

}
