package lotto.view.mapper;

public enum OutputMessage {

    RESULT_START("당첨 통계\n---"),
    PURCHASE_LOTTO_COUNT("%d개를 구매했습니다."),
    LOTTO_DETAIL("[%d, %d, %d, %d, %d, %d]"),
    EACH_LOTTO_RESULT("%s - %d개"),
    WINNING_RATE("총 수익률은 %.1f%%입니다.");

    private String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String outputMessage() {
        return outputMessage;
    }

}
