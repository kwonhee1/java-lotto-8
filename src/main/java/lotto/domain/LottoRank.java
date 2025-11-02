package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

    EMPTY (0),
    FIFTH (5000),
    FOURTH (50000),
    THIRD (1500000),
    SECOND (30000000),
    FIRST (2000000000);

    private int price;

    LottoRank(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static List<LottoRank> valuesOrderPrice() {
        return Arrays.stream(values())
                .filter(e->!e.equals(EMPTY))
                .sorted((a,b)->a.getPrice()-b.getPrice())
                .toList();
    }

}

