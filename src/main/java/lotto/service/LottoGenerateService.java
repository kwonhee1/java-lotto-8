package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constraint.LottoConstraint;
import lotto.domain.Lotto;
import lotto.domain.vo.LottoPurchaseCount;

public class LottoGenerateService {

    public List<Lotto> generateLottos(LottoPurchaseCount tryCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < tryCount.value(); i++){
            List<Integer> randomIntegers = Randoms.pickUniqueNumbersInRange(
                    LottoConstraint.LOTTO_RANGE_START_INCLUSIVE,
                    LottoConstraint.LOTTO_RANGE_END_INCLUSIVE,
                    LottoConstraint.LOTTO_COUNT
            );
            lottos.add(new Lotto(randomIntegers));
        }

        return lottos;
    }

}
