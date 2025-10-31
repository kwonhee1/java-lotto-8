package lotto.dto;

import lotto.domain.LottoRank;

public class LottoResultDto {

    private LottoRank rank;

    public LottoResultDto(LottoRank rank) {
        this.rank = rank;
    }

    public int getPrice() {
        return rank.getPrice();
    }

    public LottoRank getLottoRank() {
        return rank;
    }

}
