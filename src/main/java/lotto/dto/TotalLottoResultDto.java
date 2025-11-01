package lotto.dto;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoRank;

public class TotalLottoResultDto {

    private int lottoCount = 0;
    private int totalWinningPrice = 0;
    private Map<LottoRank, Integer> resultMap = new HashMap<LottoRank, Integer>();

    public void addResult(LottoRank rank) {
        lottoCount++;
        totalWinningPrice += rank.getPrice();
        LottoRank resultRank = rank;
        resultMap.put(resultRank, oldValue(resultRank)+1);
    }

    public int getTotalLottoCount() {
        return lottoCount;
    }

    public int getTotalWinningPrice() {
        return totalWinningPrice;
    }

    public int getWinningCount(LottoRank lottoRank) {
        Integer winningCount = resultMap.get(lottoRank);
        return winningCount != null ? winningCount : 0;
    }

    public int getWinningPrice(LottoRank lottoRank) {
        Integer count = resultMap.get(lottoRank);

        if(count == null)
            return 0;

        return count * lottoRank.getPrice();
    }

    private int oldValue(LottoRank lottoRank) {
        Integer oldValue = resultMap.get(lottoRank);

        return oldValue != null ? oldValue : 0;
    }

}
