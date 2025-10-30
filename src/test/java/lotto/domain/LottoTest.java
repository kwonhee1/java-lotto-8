package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    void 로또_번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45 사이 숫자이다")
    public void lottoNumberTest() {
        List<Integer> listWithBigInt = List.of(1, 2, 3, 4, 5, 46);
        List<Integer> listWithLowInt = List.of(1, 2, 3, 4, 5, 0);

        Assertions.assertThatThrownBy(()->new Lotto(listWithBigInt))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->new Lotto(listWithLowInt))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto는 다른 숫자를 포함하는지 판단해준다")
    public void containTest() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Integer otherNumber = 5;

        boolean isContain = lotto.contains(otherNumber);

        Assertions.assertThat(isContain).isTrue();
    }
}
