package lotto.controller;

import lotto.controller.exception.TargetException;

public class TestExceptionHandler {

    @TargetException(TestException.class)
    public <T extends IllegalArgumentException> String handelTestException(T e) {
        return String.valueOf(((TestException)e).getValue());
    }

}
