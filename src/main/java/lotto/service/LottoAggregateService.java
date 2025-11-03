package lotto.service;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.dto.LottoAggregateDto;

public class LottoAggregateService {

    public LottoAggregateDto aggregate(List<LottoResult> drawResult) {
        LottoAggregateDto dto = new LottoAggregateDto();
        drawResult.forEach(result->dto.addResult(result.lottoRank()));
        return dto;
    }

}
