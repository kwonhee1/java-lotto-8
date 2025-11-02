package lotto.view;

public enum ErrorMessage {

    DUPLICATE_LOTTO_NUMBER("중복된 로또 번호입니다."),
    ILLEGAL_LOTTO_NUMBER("로또 번호는 1이상 45이하의 정수입니다. %s는 잘못된 로또 번호입니다"),
    ILLEGAL_LOTTO_LENGTH("로또 번호는 6자리 숫자입니다."),
    ILLEGAL_PURCHASE_LOTTO_PRICE("로또 가격은 1000의 배수입니다. %s는 잘못된 가격입니다."),
    NUMBER_FORMAT("숫자가 아닙니다.");

    private final static String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(String... args) {
        return ERROR + String.format(message, args);
    }

}
