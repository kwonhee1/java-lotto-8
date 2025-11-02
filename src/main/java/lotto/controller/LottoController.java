package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.controller.exception.ExceptionMapper;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.domain.vo.LottoPurchasePrice;
import lotto.domain.vo.LottoPurchaseCount;
import lotto.domain.service.LotteryDrawService;
import lotto.domain.service.LottoGenerateService;
import lotto.dto.TotalLottoResultDto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.mapper.OutputMapper;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;

    private ExceptionMapper exceptionMapper = new ExceptionMapper();

    private LottoGenerateService generateService = new LottoGenerateService();
    private LotteryDrawService lotteryDrawService = new LotteryDrawService();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoPurchaseCount purchaseCount = supply(()->inputLottoTryCount());
        List<Lotto> purchasedLottos = generateLottos(purchaseCount);
        WinningLotto winningLotto = supply(()->inputWinningLotto());
        List<LottoResult> lottoDrawResult = lotteryDraw(winningLotto, purchasedLottos);
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

    private List<LottoResult> lotteryDraw(WinningLotto winningLotto, List<Lotto> lottos) {
        return lotteryDrawService.lotteryDraw(winningLotto, lottos);
    }

    private void printLottoResult(List<LottoResult> drawResult, LottoPurchaseCount purchaseCount) {
        TotalLottoResultDto resultDto = convertToTotalLottoResultDto(drawResult);

        outputView.print(OutputMapper.totalLottoResultToString(resultDto));

        int purchasePrice = LottoPurchasePrice.getPriceFromPurchaseCount(purchaseCount);
        outputView.print(OutputMapper.getWinningRate(purchasePrice, resultDto.getTotalWinningPrice()));
    }

    private TotalLottoResultDto convertToTotalLottoResultDto(List<LottoResult> drawResult) {
        TotalLottoResultDto dto = new TotalLottoResultDto();
        drawResult.forEach(result->dto.addResult(result.lottoRank()));
        return dto;
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
