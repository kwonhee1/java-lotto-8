package lotto.domain;

import lotto.dto.LottoResultDto;

public class LottoResult {

    private LottoRank rank;

    public LottoResult(int winningCount, boolean isBonus) {
        this.rank = findRank(winningCount, isBonus);
    }

    public LottoResultDto toDto() {
        return new LottoResultDto(rank);
    }

    private LottoRank findRank(int winningCount, boolean isBonus) {
        if(winningCount == 6)
            return LottoRank.FIRST;
        if(winningCount == 5 && isBonus)
            return LottoRank.SECOND;
        if(winningCount == 5)
            return LottoRank.THIRD;
        if(winningCount == 4)
            return LottoRank.FOURTH;
        if(winningCount == 3)
            return LottoRank.FIFTH;
        return LottoRank.EMPTY;
    }

}
