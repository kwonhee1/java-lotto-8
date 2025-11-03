package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.vo.LottoPurchasePrice;
import lotto.dto.LottoAggregateDto;
import lotto.view.mapper.OutputMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputMapperTest {

    @Test
    @DisplayName("lotto 구매 갯수를 출력하기 위한 message")
    public void lottoPurchaseCountToStringTest() {
        int price = 3000;

        Assertions.assertThat(OutputMapper.lottoPurchaseCountToString(new LottoPurchasePrice(price)))
                .isEqualTo("3개를 구매했습니다.");
    }

    @Test
    @DisplayName("구매한 lotto를 출력하기 위한 message")
    public void lottoListToStringTest() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(7,8,9,10,11,12));

        Assertions.assertThat(OutputMapper.lottoListToString(List.of(lotto1, lotto2)))
                .contains("[1, 2, 3, 4, 5, 6]")
                .contains("[7, 8, 9, 10, 11, 12]");
    }

    @Test
    @DisplayName("lotto 결과를 출력하기 위한 message")
    public void totalLottoResultToStringTest() {
        LottoAggregateDto totalResult = new LottoAggregateDto();
        totalResult.addResult(LottoRank.FIFTH);

        Assertions.assertThat(OutputMapper.totalLottoResultToString(totalResult))
                .contains("당첨 통계\n---")
                .contains("3개 일치 (5,000원) - 1개")
                .contains("4개 일치 (50,000원) - 0개")
                .contains("5개 일치 (1,500,000원) - 0개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개")
                .contains("6개 일치 (2,000,000,000원) - 0개");
    }

    @Test
    @DisplayName("수익율을 출력하기위한 message")
    public void getWinningRateTest() {
        int purchasePrice = 8000;
        int winningPrice = 5000;

        Assertions.assertThat(OutputMapper.getWinningRate(purchasePrice, winningPrice))
                .isEqualTo("총 수익률은 62.5%입니다.");
    }

}
