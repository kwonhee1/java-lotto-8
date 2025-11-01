package lotto.view.mapper;

import java.util.Arrays;
import lotto.domain.LottoRank;

public enum LottoRankMessage {

    FIRST(LottoRank.FIRST, "6개 일치 (%,d)"),
    SECOND(LottoRank.SECOND, "5개 일치, 보너스 볼 일치 (%,d)"),
    THIRD(LottoRank.THIRD, "5개 일치 (%,d)"),
    FOURTH(LottoRank.FOURTH, "4개 일치 (%,d)"),
    FIFTH(LottoRank.FIFTH, "3개 일치 (%,d)");

    private LottoRank lottoRank;
    private String describe;

    LottoRankMessage(LottoRank rank, String describeRegex) {
        this.lottoRank = rank;
        this.describe = String.format(describeRegex, rank.getPrice());
    }

    public static LottoRankMessage of(LottoRank rank) {
        return Arrays.stream(LottoRankMessage.values())
                .filter(e -> e.lottoRank.equals(rank))
                .findFirst()
                .orElseGet(()->{throw new NoSuchElementException();});
    }

    public String getDescribe() {
        return describe;
    }

}
