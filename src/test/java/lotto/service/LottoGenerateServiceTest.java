package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGenerateServiceTest {

    private LottoGenerateService service = new LottoGenerateService();

    @Test
    @DisplayName("lotto generate service는 lotto를 생성합니다")
    public void generateLottoTest() {
        List<Lotto> lottos = service.generateLottos(3);

        Assertions.assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Lotto 생성은 1개 이상만 가능합니다")
    public void generateIllegalLottoCountTest() {
        Assertions.assertThatThrownBy(() -> service.generateLottos(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
