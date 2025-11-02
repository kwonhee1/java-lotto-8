package lotto.dto;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoRank;

public class TotalLottoResultDto {

    private Map<LottoRank, Integer> lottoResultMap = new HashMap<LottoRank, Integer>();

    private int lottoCount = 0;
    private int totalWinningPrice = 0;

    public void addResult(LottoRank lottoRank) {
        lottoResultMap.put(lottoRank, oldValue(lottoRank)+1);
        lottoCount++;
        totalWinningPrice += lottoRank.getPrice();
    }

    public int getTotalLottoCount() {
        return lottoCount;
    }

    public int getTotalWinningPrice() {
        return totalWinningPrice;
    }

    public int getWinningCount(LottoRank lottoRank) {
        Integer winningCount = lottoResultMap.get(lottoRank);
        return winningCount != null ? winningCount : 0;
    }

    public int getWinningPrice(LottoRank lottoRank) {
        Integer count = lottoResultMap.get(lottoRank);

        if(count == null)
            return 0;

        return count * lottoRank.getPrice();
    }

    private int oldValue(LottoRank lottoRank) {
        Integer oldValue = lottoResultMap.get(lottoRank);

        if(oldValue == null)
            return 0;

        return oldValue.intValue();
    }

}
