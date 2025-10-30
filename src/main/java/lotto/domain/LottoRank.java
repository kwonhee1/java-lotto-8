package lotto.domain;

public enum LottoRank {

    EMPTY (0),
    FIRST (5000),
    SECOND (50000),
    THIRD (1500000),
    FOURTH (30000000),
    FIFTH (2000000000);

    private int price;

    LottoRank(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
