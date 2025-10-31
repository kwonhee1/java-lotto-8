package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.vo.LottoPurchaseCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGenerateServiceTest {

    private LottoGenerateService service = new LottoGenerateService();

    @Test
    @DisplayName("lotto generate service는 lotto를 생성합니다")
    public void generateLottoTest() {
        LottoPurchaseCount tryCount = new LottoPurchaseCount(3);
        List<Lotto> lottos = service.generateLottos(tryCount);

        Assertions.assertThat(lottos.size()).isEqualTo(3);
    }

}
