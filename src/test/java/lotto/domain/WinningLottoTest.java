package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("Lotto number와 bonus number가 곂치면 error가 발생한다")
    public void duplicateBonusNumber() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Integer bonusNumber = 5;

        Assertions.assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Winning Lotto는 다른 Lotto와 몇개 맞았는지 구해준다")
    public void winCountTest() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        Integer bonusNumber = 20;
        List<Integer> otherLottoNumbers = List.of(1,2,3,10,11,12);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto otherLotto = new Lotto(otherLottoNumbers);

        int winningCount = winningLotto.winningCount(otherLotto);

        Assertions.assertThat(winningCount).isEqualTo(3);
    }

    @Test
    @DisplayName("Winning Lotto는 다른 Lotto가 bonus 번호가 맞았는지 구해준다")
    public void isBonusTest() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        Integer bonusNumber = 20;
        List<Integer> otherLottoNumbers = List.of(1,2,3,10,11,12);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto otherLotto = new Lotto(otherLottoNumbers);

        boolean isBonus = winningLotto.isBonus(otherLotto);

        Assertions.assertThat(isBonus).isEqualTo(false);
    }

    @Test
    @DisplayName("winning lotto 번호가 6개가 아니면 예외가 발생한다")
    void 로또_번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 20))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 20))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Winning Lotto 번호에 bonus 번호 포함 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicateWinningLotto() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("winning lotto 번호는 1 ~ 45 사이 숫자이다")
    public void lottoNumberTest() {
        List<Integer> listWithBigInt = List.of(1, 2, 3, 4, 5, 46);
        List<Integer> listWithLowInt = List.of(1, 2, 3, 4, 5, 0);

        Assertions.assertThatThrownBy(()->new WinningLotto(listWithBigInt, 20))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->new WinningLotto(listWithLowInt, 20))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->new WinningLotto(List.of(1,2,3,4,5,6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
