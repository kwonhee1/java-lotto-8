package lotto.view.mapper;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.vo.LottoPurchaseCount;
import lotto.domain.vo.LottoPurchasePrice;
import lotto.dto.TotalLottoResultDto;

public class OutputMapper {

    public static String lottoPurchaseCountToString(LottoPurchaseCount purchaseCount) {
        return String.format(OutputMessage.PURCHASE_LOTTO_COUNT.outputMessage(), purchaseCount.value()).toString();
    }

    public static String lottoListToString(List<Lotto> lottoList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            String eachLottoDescribe = String.format(OutputMessage.LOTTO_DETAIL.outputMessage(), lotto.getLottoNumbers().toArray());
            stringBuilder.append(eachLottoDescribe).append("\n");
        }
        return stringBuilder.toString();
    }

    public static String totalLottoResultToString(TotalLottoResultDto result) {
        StringBuilder resultBuilder = new StringBuilder(OutputMessage.RESULT_START.outputMessage());

        for(LottoRank eachRank : LottoRank.values()){ // values 함수 변경하기!
            String eachResultDescribe = lottoResultToString(
                    eachRank,
                    result.getWinningCount(eachRank)
            );
            resultBuilder.append(eachResultDescribe);
            resultBuilder.append("\n");
        }

        return resultBuilder.toString();
    }

    public static String getWinningRate(LottoPurchasePrice purchasePrice, int totalWinningPrice) {
        double winningRate = (double)totalWinningPrice / purchasePrice.value() * 100;
        return String.format(OutputMessage.WINNING_RATE.outputMessage(), winningRate).toString();
    }

    private static String lottoResultToString(LottoRank lottoRank, int count) {
        LottoRankMessage lottoMessage = LottoRankMessage.of(lottoRank);

        return String.format(
                        OutputMessage.EACH_LOTTO_RESULT.outputMessage(),
                        lottoMessage.getDescribe(),
                        count
                )
                .toString();
    }

}
