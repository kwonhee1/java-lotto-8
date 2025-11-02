package lotto.controller;

public class TestException extends IllegalArgumentException{
    private int value;
    public TestException(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
