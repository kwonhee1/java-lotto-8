package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("String.format 함수 반올림 test")
    public void StringFormatTest(){
        double d1 = 3.54;
        double d2 = 3.55;
        double d3 = 3.56;
        String format = "%.1f";

        Assertions.assertThat(String.format(format, d1)).isEqualTo("3.5");
        Assertions.assertThat(String.format(format, d2)).isEqualTo("3.6");
        Assertions.assertThat(String.format(format, d3)).isEqualTo("3.6");
    }
}
