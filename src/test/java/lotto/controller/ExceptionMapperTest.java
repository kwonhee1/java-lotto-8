package lotto.controller;

import lotto.controller.exception.ExceptionMapper;
import lotto.domain.exception.IllegalLottoCountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionMapperTest {

    @Test
    @DisplayName("제대로된 함수를 선택하는지 test")
    public void exceptionMapperTest() {
        ExceptionMapper exceptionMapper = new ExceptionMapper(new TestExceptionHandler());

        String message = exceptionMapper.toMessage(new TestException(5));

        Assertions.assertThat(message).isEqualTo("5");
    }

    @Test
    @DisplayName("handler가 없는 경우 error 발생")
    public void noHandlerExceptionMapperTest() {
        ExceptionMapper exceptionMapper = new ExceptionMapper(new TestExceptionHandler());

        Assertions.assertThatThrownBy(() -> exceptionMapper.toMessage(new IllegalLottoCountException()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
