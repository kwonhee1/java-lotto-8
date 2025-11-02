package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    @Test
    @DisplayName("random 값은 법위 내에 있어야 합니다")
    public void pickUniqueNumbersInRangeTest() {
        int start = 0;
        int end = 100;
        int count = 100;

        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(start, end,count);

        Assertions.assertThat(randomNumbers).hasSize(count);
        for(Integer number : randomNumbers)
            Assertions.assertThat(number).isBetween(start, end);
    }

    @Test
    @DisplayName("범위에 대한 validate test")
    public void validateTest() {
        Assertions.assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(0,1,3));
        Assertions.assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(5,1,3));
    }
}
