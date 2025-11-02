package lotto.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitUtilTest {

    @Test
    @DisplayName("문자열을 나눈다")
    public void splitIntegerTest() {
        String before = "1, 2, 3, 4 ,5,6";

        List<Integer> after = SplitUtil.split(before, ",", Integer::parseInt);

        org.junit.jupiter.api.Assertions.assertAll(
                ()-> Assertions.assertThat(after).containsAll(List.of(1, 2, 3, 4, 5, 6)),
                ()-> Assertions.assertThat(after).hasSize(6)
        );
    }

    @Test
    @DisplayName("문자열을 나눈다")
    public void splitCharacterTest() {
        String before = "a, b, c, d ,e,f";

        List<Character> after = SplitUtil.split(before, ",", (str)->str.charAt(0));

        org.junit.jupiter.api.Assertions.assertAll(
                ()-> Assertions.assertThat(after).containsAll(List.of('a', 'b', 'c', 'd', 'e', 'f')),
                ()-> Assertions.assertThat(after).hasSize(6)
        );
    }
    
}
